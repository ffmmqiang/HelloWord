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
// $Log: HttpCommunicationException.java,v $
// Revision 1.2  2010/01/27 05:56:55  liangqiang
// init version
//
// 

package com.ecc.liana.exception;

/**
 * Liana HTTP通信异常
 * 
 * @version 1.0 2008-07-10
 * @author zhanghao@yuchengtech.com
 */
public class HttpCommunicationException extends TranFailException {
	/**
	 * Field serialVersionUID.
	 */
	private static final long serialVersionUID = 20080710135712L;
	/**
	 * 错误代码
	 */
	private static final String ERROR_CODE = "EBLN0015";

	public HttpCommunicationException(Exception ex) {
		super( ERROR_CODE, ex );
	}
}
