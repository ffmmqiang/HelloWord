////////////////////////////////////////////////////////////////////////////
// 
// Copyright (C) 2009 e-Channels CORPORATION
// 
// ALL RIGHTS RESERVED BY e-Channels CORPORATION, THIS PROGRAM
// MUST BE USED SOLELY FOR THE PURPOSE FOR WHICH IT WAS  
// FURNISHED BY e-Channels CORPORATION, NO PART OF THIS PROGRAM
// MAY BE REPRODUCED OR DISCLOSED TO OTHERS, IN ANY FORM
// WITHOUT THE PRIOR WRITTEN PERMISSION OF e-Channels CORPORATION.
// USE OF COPYRIGHT NOTICE DOES NOT EVIDENCE PUBLICATION
// OF THE PROGRAM
// 
//			e-Channels CONFIDENTIAL AND PROPRIETARY
// 
////////////////////////////////////////////////////////////////////////////
// 
// $Log: LianaExceptionView.java,v $
// Revision 1.3  2010/01/28 07:33:02  liangqiang
// init version
//
// 

package com.ecc.liana.exception;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecc.emp.core.EMPConstance;
import com.ecc.emp.web.servlet.view.ExceptionView;
import com.ecc.emp.web.servlet.view.JSPView;
import com.ecc.liana.base.LianaConstants;
import com.ecc.liana.base.LianaErrorInfo;
import com.ecc.liana.base.LianaStandard;
import com.ecc.liana.base.Trace;

/**
 * Liana 异常页面重定向类
 * 
 * @version 1.0 2008-05-29
 * @author zhanghao@yuchengtech.com
 */
public class LianaExceptionView extends ExceptionView {
	/**
	 * 普通错误页面
	 */
	private static final String JSP_ERROR_DEFAULT = "error_default.jsp";
	/**
	 * 严重错误页面
	 */
	private static final String JSP_ERROR_FATAL = "error_fatal.jsp";
	/**
	 * 错误页面的根目录，相对于WebContent
	 */
	private String urlBase;

	/**
	 * Method render.
	 * 
	 * @param model
	 *            Map
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @param jspRootPath
	 *            String
	 * @see com.ecc.emp.web.servlet.view.View#render(Map, HttpServletRequest, HttpServletResponse, String)
	 */
	public void render( Map model, HttpServletRequest request, HttpServletResponse response, String jspRootPath )
	{
		String errorCode = null;
		String errorPage = null;
		Exception empException = (Exception) model.get( EMPConstance.ATTR_EXCEPTION );
		// 取得错误代码
		if ( empException instanceof TranFailException )
		{
			TranFailException lianaException = (TranFailException) empException;
			errorCode = lianaException.getErrorCode();
			LianaErrorInfo errorInfo = LianaStandard.getErrorInfo( errorCode );
			if ( errorInfo != null )
			{
				errorPage = errorInfo.getReturnPage();
				if ( errorPage == null )
				{
					switch ( errorInfo.getLevel() ) {
						case 1 : {
							// 错误级别为1的异常，返回到提交页面
							JSPView inputView = (JSPView) request.getAttribute( LianaConstants.INPUT_VIEW_KEY );
							if ( inputView != null )
							{
								request.removeAttribute( LianaConstants.INPUT_VIEW_KEY );
								// 存入错误信息
								request.setAttribute( LianaConstants.INPUT_ERROR_KEY, errorInfo.getShowMsg() );
								errorPage = jspRootPath + inputView.getUrl();
							}
							break;
						}
						case 2 :
						default :
							errorPage = urlBase + JSP_ERROR_DEFAULT;
							break;
						case 3 :
							errorPage = urlBase + JSP_ERROR_FATAL;
							break;
					}
				}
				else
				{
					errorPage = urlBase + errorPage;
				}
			}
		}
		if ( errorPage == null )
		{
			errorPage = urlBase + JSP_ERROR_DEFAULT;
		}
		setModelToRequest( model, request );
		RequestDispatcher dispatcher = request.getRequestDispatcher( errorPage );
		try
		{
			dispatcher.forward( request, response );
		}
		catch ( Exception ex )
		{
			Trace.logError( EMPConstance.EMP_MVC, "重定向错误页面失败", ex );
		}
	}

	/**
	 * Method setUrlBase.
	 * 
	 * @param urlBase
	 *            String
	 */
	public void setUrlBase( String urlBase )
	{
		this.urlBase = urlBase;
	}
}
