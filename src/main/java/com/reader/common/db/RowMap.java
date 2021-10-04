package com.reader.common.db;

import java.util.HashMap;
import java.util.Map;

public class RowMap {
	final Map<String, Object> map = new HashMap<String, Object>();

	public void setValue(String key, Object value) {
		this.map.put(key, value);
	}

	public Object getValue(String key) {
		return this.map.get(key);
	}

}
