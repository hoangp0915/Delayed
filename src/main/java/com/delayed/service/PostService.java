package com.delayed.service;

import java.util.List;

import com.delayed.model.PostData;
import com.delayed.model.PostModel;
import com.delayed.model.UserModel;

public interface PostService {

	/**
	 * Insert data into database
	 * 
	 * @param post
	 * @return
	 */
	PostModel save(PostModel post, UserModel user);

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
	void updateById(PostModel post, UserModel user) throws Exception;

	/**
	 * Delete multiple record by ids
	 * 
	 * @param ids
	 */
	void deleteById(Integer id);

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
	
	List<PostModel> listFavorite(Integer id);
	
	Integer insertFavoriteArticles(Integer userId, Integer postId);
	
	Integer getFavoriteArticles(Integer userId, Integer postId);
	
	void deleteFavoriteArticle(Integer userId, Integer postId);
}