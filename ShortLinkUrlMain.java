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
// $Log: AddContextDataToICollAction.java,v $
// Revision 1.2  2010/01/27 08:27:39  liangqiang
// adjust some
//
// Revision 1.1  2010/01/27 05:56:55  liangqiang
// init version
//
// 

package com.a;

import java.util.ArrayList;
import java.util.List;

import com.ecc.emp.core.Context;
import com.ecc.emp.core.EMPException;
import com.ecc.liana.base.LianaAction;
import com.ecc.liana.exception.TranFailException;
import com.ecc.liana.perbank.action.ShortLinkUrlAction;
import com.ecc.liana.perbank.action.ShortUrlChangeAction;
import com.ecc.liana.perbank.action.ShortUrlChangeLongUrlAction ; 



public class ShortLinkUrlMain{
	
	public static void main(String[] args){
		a();  
		
	}
	public static void a() {
		
		ShortLinkUrlAction shortLink = new ShortLinkUrlAction();
		long flowId = 0l;
		// 4063661011177271
		// 5201521211494100
		flowId = Long.parseLong("6225601620000035");
		//String flowId = ;
		
		String  encrCode =  shortLink.getShorUrl(flowId);
		System.out.println(encrCode);
	//	String mobileTemp = String.valueOf(changeAfter);
		String bb=encrCode;
		String changeBefore = bb.substring(0, bb.length());
		ShortUrlChangeLongUrlAction b =  new ShortUrlChangeLongUrlAction() ; 
		ShortUrlChangeAction su = new ShortUrlChangeAction();
		long longUrlTemp = su.getShortSrc(su.getId(changeBefore));
		System.out.println(longUrlTemp);
	}
	
	
}