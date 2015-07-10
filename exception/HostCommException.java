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
 * LianaCommAction主机通信异常
 * 
 * @version 1.0 2011-01-04
 * @author xuzhe@yuchengtech.com
 */
public class HostCommException extends TranFailException {
	/**
	 * Field serialVersionUID.
	 */
	private static final long serialVersionUID = 20110104182712L;
	/**
	 * 错误代码
	 */
	private static final String ERROR_CODE = "EBLN2000";

	/**
	 * LianaCommAction主机通信异常
	 * @param ex 主机通讯异常
	 */
	public HostCommException( Exception ex ) {
		super( ERROR_CODE, "通讯异常",ex );
	}
}
