package com.delayed.dao;

import java.util.List;

import com.delayed.model.FavoriteArticles;
import com.delayed.model.PostModel;

public interface PostDao extends ConnectionDatabase<PostModel> {

	/**
	 * Find one record
	 * 
	 * @param id
	 * @return
	 */
	PostModel findOne(Integer id);

	/**
	 * Insert record into database
	 * 
	 * @param post
	 * @return
	 */
	Integer save(PostModel post);

	/**
	 * Find all record
	 * 
	 * @return
	 */
	List<PostModel> findAll();

	/**
	 * update record
	 * 
	 * @param post
	 */
	void update(PostModel post);

	/**
	 * delete multiple record by ids
	 * 
	 * @param ids
	 */
	void deleteById(Integer id);

	/**
	 * Find record limit
	 * 
	 * @param limit
	 * @return
	 */
	List<PostModel> findRecordLimit(Integer limit);

	List<PostModel> listRecord(Integer page, Integer size);

	List<PostModel> findPostMostViewed();

	List<PostModel> listRecordByCategory(Integer cate, Integer page, Integer size);
	
	List<PostModel> searchByKey(String searchKey, Integer page, Integer size);
	
	List<FavoriteArticles> listFavorite(Integer id);
	
	Integer insertFavoriteArticles(Integer userId, Integer postId);
	
	Integer getFavoriteArticles(Integer userId, Integer postId);
	
	void deleteFavoriteArticle(Integer userId, Integer postId);
	
	void updateView(PostModel post);
}
