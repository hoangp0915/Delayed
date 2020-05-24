/**
 * 
 */
package com.delayed.dao;

import java.util.List;

import com.delayed.model.CategoryModel;
import com.delayed.model.PostModel;

/**
 * @author hoang
 *
 */
public interface CategoryDao {
	
	CategoryModel findOne(Integer id);

	Integer save(CategoryModel cat);

	List<CategoryModel> findAll();

	void update(PostModel post);

	void deleteById(String id);
}
