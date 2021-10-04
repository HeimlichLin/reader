package com.reader.common.codegenerate;

public enum SystemDefine {
	
	FOSP_AP("pfosp/ap/"), //
	FOSP_BK("pfosp/bk/"), //
	FTZC_AP("pftzc/ap/"), //
	FTZC_BK("pftzc/bk/"), //
	CLMS_AP("pclms/ap/"), //
	CLMS_BK("pclms/bk/"), //

	;
	final String configFile;
	final static String CONFIG_FILE_DEFINE = "config.properties";

	private SystemDefine(String parent) {
		this.configFile = parent+CONFIG_FILE_DEFINE;
	}

	public String getConfigFile() {
		return configFile;
	}

}
