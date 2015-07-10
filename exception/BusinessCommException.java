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

package com.ecc.liana.exception;

/**
 * LianaCommAction主机业务异常
 * 
 * @version 1.0 2011-01-04
 * @author xuzhe@yuchengtech.com
 */
public class BusinessCommException extends TranFailException {
	/**
	 * Field serialVersionUID.
	 */
	private static final long serialVersionUID = 20110104183512L;

	/**
	 * LianaCommAction主机业务异常
	 * @param errorCode 错误码
	 * @param errorMessage 错误信息
	 */
	public BusinessCommException( String errorCode, String errorMessage ) {
		super( errorCode, errorMessage );
	}
}
