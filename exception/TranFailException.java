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
// $Log: TranFailException.java,v $
// Revision 1.5  2010/05/10 12:24:12  qiuweizhi
// *** empty log message ***
//
// Revision 1.4  2010/01/28 07:33:11  liangqiang
// init version
//
// 

package com.ecc.liana.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import com.ecc.emp.core.EMPException;
import com.ecc.liana.base.LianaConstants;

/**
 * Liana 交易异常基类
 * 
 * @version 1.1 2008-01-17
 * @author zhanghao@yuchengtech.com
 */
public class TranFailException extends EMPException {
	/**
	 * Field serialVersionUID. (value is 6857754983999980461)
	 */
	private static final long serialVersionUID = 6857754983999980461L;
	/**
	 * ORACLE SQLSTATE 主键或唯一索引冲突
	 */
	private static final String SQLSTATE_DUPLICATE_INDEX_ORACLE = "23000";
	/**
	 * DB2 SQLSTATE 主键或唯一索引冲突
	 */
	private static final String SQLSTATE_DUPLICATE_INDEX_DB2 = "23505";
	/**
	 * 主键或唯一索引冲突时抛出的异常的错误代码
	 */
	private static final String ERROR_CODE_DUPLICATE_INDEX = "EBLN5003";
	
	private boolean printTraceMessage = true;

	/**
	 * Constructor for TranFailException.
	 * 
	 * @param errorCode
	 *            String
	 */
	public TranFailException(String errorCode) {
		super();
		super.setErrorCode( errorCode );
	}
	
	public TranFailException(String errorCode, boolean printMessage) {
		super();
		super.setErrorCode( errorCode );
		setPrintTraceMessage(printMessage);
	}

	/**
	 * Constructor for TranFailException.
	 * 
	 * @param errorCode
	 *            String
	 * @param message
	 *            String
	 */
	public TranFailException(String errorCode, String message) {
		super( message );
		super.setErrorCode( errorCode );
		super.setShowMessage( message );
	}
	
	public TranFailException(String errorCode, String message, boolean printMessage) {
		super( message );
		super.setErrorCode( errorCode );
		super.setShowMessage( message );
		setPrintTraceMessage(printMessage);
	}

	/**
	 * Constructor for TranFailException.
	 * 
	 * @param errorCode
	 *            String
	 * @param cause
	 *            Throwable
	 */
	public TranFailException(String errorCode, Throwable cause) {
		super( cause );
		super.setErrorCode( errorCode );
	}
	
	public TranFailException(String errorCode, Throwable cause, boolean printMessage) {
		super( cause );
		super.setErrorCode( errorCode );
		setPrintTraceMessage(printMessage);
	}

	/**
	 * Constructor for TranFailException.
	 * 
	 * @param errorCode
	 *            String
	 * @param message
	 *            String
	 * @param cause
	 *            Throwable
	 */
	public TranFailException(String errorCode, String message, Throwable cause) {
		super( message, cause );
		super.setErrorCode( errorCode );
		super.setShowMessage( message );
	}

	/**
	 * Constructor for TranFailException.
	 * 
	 * @param errorCode
	 *            String
	 * @param message
	 *            String
	 * @param cause
	 *            Throwable
	 */
	public TranFailException(String errorCode, String message, Throwable cause, boolean printMessage) {
		super( message, cause );
		super.setErrorCode( errorCode );
		super.setShowMessage( message );
		setPrintTraceMessage(printMessage);
	}
	
	/**
	 * Constructor for TranFailException.
	 * 
	 * @param cause
	 *            Throwable
	 */
	public TranFailException(Throwable cause) {
		super( cause );
	}
	
	public TranFailException(Throwable cause, boolean printMessage) {
		super( cause );
		setPrintTraceMessage(printMessage);
	}

	/**
	 * Constructor for TranFailException.
	 * 
	 * @param ex
	 */
	public TranFailException(SQLException ex) {
		super( LianaConstants.DEFAULT_ERROR_CODE, null, ex );
		String sqlState = ex.getSQLState();
		switch ( LianaConstants.DB_TYPE ) {
			case LianaConstants.DB_TYPE_ORACLE : {
				if ( SQLSTATE_DUPLICATE_INDEX_ORACLE.equals( sqlState ) )
				{
					super.setErrorCode( ERROR_CODE_DUPLICATE_INDEX );
				}
				break;
			}
			case LianaConstants.DB_TYPE_DB2 : {
				if ( SQLSTATE_DUPLICATE_INDEX_DB2.equals( sqlState ) )
				{
					super.setErrorCode( ERROR_CODE_DUPLICATE_INDEX );
				}
				break;
			}
		}
	}

	/**
	 * 取得Error的StackTrace
	 * 
	 * @return String
	 */
	public String getErrorStack()
	{
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream( bo );
		printStackTrace( ps );
		String errorStack = new String( bo.toByteArray() );
		return errorStack;
	}

	public void setPrintTraceMessage(boolean printTraceMessage) {
		this.printTraceMessage = printTraceMessage;
	}

	public boolean isPrintTraceMessage() {
		return printTraceMessage;
	}

}
