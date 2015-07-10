////////////////////////////////////////////////////////////////////////////
// 
// Copyright (C) 2008 e-Channels CORPORATION
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
 * 网关交易异常
 * 
 * @version 1.0 2009-07-14
 * @author yangchao@yuchengtech.com
 */
public class DataNotFoundException extends TranFailException {
	/**
	 * Field serialVersionUID.
	 */
	private static final long serialVersionUID = 20090714135712L;
	/**
	 * 错误代码:查询无记录
	 */
	private static final String ERROR_CODE = "EBLN5001";

	public DataNotFoundException(Exception ex) {
		super( ERROR_CODE, ex );
	}
	
	/**
	 * Constructor for TranFailException.
	 * 
	 * @param errorCode
	 *            String
	 * @param message
	 *            String
	 */
	public DataNotFoundException(String errorCode, String message) {
		super(errorCode, message);
	}

}
