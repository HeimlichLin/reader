package com.reader.common.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reader.common.codegenerate.CodeParm;
import com.reader.common.context.AppContext;
import com.reader.common.object.FileLoader;

public class ConnectionUitls {
	private static Logger LOGGER = LoggerFactory.getLogger(ConnectionUitls.class);
	public static Connection getConnection(String dbString) {
		System.setProperty(CodeParm.DB_SETTING.name(), dbString);
		return getConnection();
	}

	public static Connection getConnection() {
		final String dbProperties = AppContext.get().getValue(CodeParm.DB_SETTING.name(), "db.properties");
		final File f = FileLoader.getResourcesFile(ConnectionUitls.class, dbProperties);
		final Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(f));
		} catch (final FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (final IOException e1) {
			e1.printStackTrace();
		}

		final String url = properties.getProperty("jdbc.url");
		final String driver = properties.getProperty("jdbc.driverClassName");
		Connection conn = null;
		final Properties props = new Properties();
		props.put("remarksReporting", "true");
		props.put("user", properties.getProperty("jdbc.username"));
		props.put("password", properties.getProperty("jdbc.password"));

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, props);
		} catch (final SQLException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (final ClassNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return conn;
	}

}
