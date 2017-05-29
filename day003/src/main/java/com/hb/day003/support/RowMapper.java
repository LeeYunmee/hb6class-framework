package com.hb.day003.support;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RowMapper {

	Object mapRow(ResultSet rs) throws SQLException;
	final List list = new ArrayList();
	
}
