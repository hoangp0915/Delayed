/**
 * 
 */
package com.delayed.dao.impl;

import java.util.List;

import com.delayed.dao.CategoryDao;
import com.delayed.mapper.CategoryMapper;
import com.delayed.mapper.PostMapper;
import com.delayed.model.CategoryModel;
import com.delayed.model.PostModel;

/**
 * @author hoang
 *
 */
public class CategoryDaoImpl extends ConnectionImpl<CategoryModel> implements CategoryDao  {

	@Override
	public CategoryModel findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer save(CategoryModel cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public void update(PostModel post) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

}
