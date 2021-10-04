package com.reader.common.db;

public interface Converter<Po> {
	
	Po convert(RowMap paramDataObject);

}
