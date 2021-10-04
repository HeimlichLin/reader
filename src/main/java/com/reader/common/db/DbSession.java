package com.reader.common.db;

import java.sql.Connection;
import java.util.List;

public interface DbSession {
	
	void beginTransaction();
	
	void commit();

	void close();

	Connection getConnection();

	RowMapList query(String sql);

	<Po> List<Po> select(Converter<Po> converter, String sql);

}
