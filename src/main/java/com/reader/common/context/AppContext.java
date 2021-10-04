package com.reader.common.context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.xwork.StringUtils;

import com.reader.common.codegenerate.SystemDefine;
import com.reader.common.exception.TxBusinessException;
import com.reader.common.object.FileLoader;

public class AppContext {
	
	private String config = "config.properties";
	private Properties properties = System.getProperties();
	final static AppContext CONTEXT = new AppContext();
	private boolean load = false;
	final String systemCode;

	public AppContext() {
		super();
		this.systemCode = System.getProperty("SystemDefine");
		if (StringUtils.isBlank(systemCode)) {
			throw new TxBusinessException("系統代碼不得空白");
		}
		SystemDefine systemDefine = SystemDefine.valueOf(systemCode);
		this.config = systemDefine.getConfigFile();
	}

	public void loadConfig() {
		try {
			File file = FileLoader.getResourcesFile(AppContext.class, config);
			this.properties.load(new FileInputStream(file));
			this.load = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public String getValue(String key, String defaultValue) {
		return init().getProperty(key, defaultValue);
	}

	public String getValue(String key) {
		return init().getProperty(key);
	}

	private Properties init() {
		if (!load) {
			this.loadConfig();
		}
		return properties;
	}

	public static AppContext get() {
		return CONTEXT;
	}

}
