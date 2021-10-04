package com.reader;

import com.reader.common.codegenerate.SystemDefine;
import com.reader.common.db.DbSession;
import com.reader.common.db.DbSessionFactory;

/**
 * 讀取DB設定檔 
 */
public class Reader {

	public static void main(String[] args) {
		System.setProperty("SystemDefine", SystemDefine.FOSP_AP.name());		
		final DbSession session = DbSessionFactory.get();
	}

}
