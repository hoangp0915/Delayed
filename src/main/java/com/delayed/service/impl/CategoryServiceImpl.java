package com.delayed.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.delayed.dao.CategoryDao;
import com.delayed.model.CategoryModel;
import com.delayed.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{

	@Inject
	private CategoryDao categoryDao;
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

}
