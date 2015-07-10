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
// $Log: FileAccessDeniedException.java,v $
// Revision 1.2  2010/01/27 05:56:55  liangqiang
// init version
//
// 

package com.ecc.liana.exception;

import com.ecc.emp.core.EMPException;

/**
 * 由于权限不足,文件存取被拒绝异常.
 * 
 * @version 1.0 2009-06-16
 * @author zhuding@yuchengtech.com
 */
public class FileAccessDeniedException extends EMPException {
	/**
	 * Field serialVersionUID.
	 */
	private static final long serialVersionUID = -3115977480993681654L;

	public FileAccessDeniedException() {
		super();
	}
	
	public FileAccessDeniedException(String message) {
		super(message);
	}

	public FileAccessDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileAccessDeniedException(Throwable cause) {
		super(cause);
	}
}
