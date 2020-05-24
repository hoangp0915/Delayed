package com.delayed.dao;

import java.util.List;

import com.delayed.mapper.RowMapper;

public interface ConnectionDatabase<T> {

	/**
	 * execute query
	 * 
	 * @param <T>
	 * @param sql
	 * @param rowMapper
	 * @param parameters
	 * @return
	 */
	@SuppressWarnings("hiding")
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);

	/**
	 * Update
	 * 
	 * @param sql
	 * @param parameters
	 */
	void update(String sql, Object... parameters);

	/**
	 * Insert
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	Integer insert(String sql, Object... parameters);

	/**
	 * Count
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	int count(String sql, Object... parameters);
}
