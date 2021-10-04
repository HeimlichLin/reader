package com.reader.common.db;

import com.reader.common.codegenerate.CodeParm;
import com.reader.common.context.AppContext;

public class DbSessionFactory {
	private static ThreadLocal<DbSession> SESSION = new ThreadLocal<DbSession>();

	public static DbSession get() {
		final String dbProperties = AppContext.get().getValue(CodeParm.DB_SETTING.name());
		DbSession dbSession = SESSION.get();
		if (dbSession == null) {
			dbSession = new DbSessionImpl(dbProperties);
			SESSION.set(dbSession);
		}
		return dbSession;
	}

}
