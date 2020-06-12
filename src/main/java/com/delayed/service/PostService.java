package com.delayed.service;

import java.util.List;

import com.delayed.model.PostData;
import com.delayed.model.PostModel;

public interface PostService {

	/**
	 * Insert data into database
	 * 
	 * @param post
	 * @return
	 */
	PostModel save(PostModel post);

	/**
	 * Find all data
	 * 
	 * @return
	 */
	List<PostModel> findAll();

	/**
	 * Update data by id
	 * 
	 * @param post
	 * @throws Exception
	 */
	void updateById(PostModel post) throws Exception;

	/**
	 * Delete multiple record by ids
	 * 
	 * @param ids
	 */
	void deleteByIds(String ids);

	/**
	 * Find post by id
	 * 
	 * @param id
	 * @return
	 */
	PostModel findById(Integer id);

	/**
	 * find Record width Limit
	 * 
	 * @param limit
	 * @return
	 */
	List<PostModel> findRecordLimit(Integer limit);

	/**
	 * list record
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	List<PostModel> listRecord(Integer page, Integer size);

	List<PostModel> listRecordByCategory(Integer cate, Integer page, Integer size);

	List<PostModel> listRecordMostViewed();
	
	List<PostData> listPostData(List<PostModel> posts);
	
	List<PostModel> searchByKey(String searchKey, Integer page, Integer size);
}