package com.delayed.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.delayed.dao.PostDao;
import com.delayed.model.CategoryModel;
import com.delayed.model.FavoriteArticles;
import com.delayed.model.PostData;
import com.delayed.model.PostModel;
import com.delayed.model.UserModel;
import com.delayed.service.CategoryService;
import com.delayed.service.PostService;

public class PostServiceImpl implements PostService {

	@Inject
	private PostDao postDao;

	@Inject
	private CategoryService categoryService;

	/**
	 * Insert record in to database {@inheritDoc}
	 * 
	 * @see com.delayed.service.PostService#save(com.delayed.model.PostModel)
	 */
	@Override
	public PostModel save(PostModel post, UserModel user) {
		post.setCreated(new Timestamp(System.currentTimeMillis()));
		post.setCreatedBy(user.getUsername());
		Integer id = postDao.save(post);
		return postDao.findOne(id);
	}

	/**
	 * Find all record in database {@inheritDoc}
	 * 
	 * @see com.delayed.service.PostService#findAll()
	 */
	@Override
	public List<PostModel> findAll() {
		return postDao.findAll();
	}

	/**
	 * Update record by id {@inheritDoc}
	 * 
	 * @see com.delayed.service.PostService#updateById(com.delayed.model.PostModel)
	 */
	@Override
	public void updateById(PostModel post) throws Exception {
		PostModel find = postDao.findOne(post.getId());
		if (find != null) {
			post.setUpdated(new Timestamp(System.currentTimeMillis()));
			postDao.update(post);
		} else {
			throw new Exception("Post not found.");
		}
	}

	/**
	 * Delete record by ids {@inheritDoc}
	 * 
	 * @see com.delayed.service.PostService#deleteById(java.lang.String)
	 */
	@Override
	public void deleteById(Integer id) {
		postDao.deleteById(id);
	}

	/**
	 * Find record by Id {@inheritDoc}
	 * 
	 * @see com.delayed.service.PostService#findById(java.lang.Integer)
	 */
	@Override
	public PostModel findById(Integer id) {
		PostModel find = postDao.findOne(id);
		return find;
	}

	@Override
	public List<PostModel> findRecordLimit(Integer limit) {
		List<PostModel> list = postDao.findRecordLimit(limit);
		return list;
	}

	@Override
	public List<PostModel> listRecord(Integer page, Integer size) {
		if (page != 0) {
			page = page * size;
		}
		System.out.println(page);
		List<PostModel> list = postDao.listRecord(page, size);
		return list;
	}

	@Override
	public List<PostModel> listRecordMostViewed() {
		List<PostModel> list = postDao.findPostMostViewed();
		return list;
	}

	@Override
	public List<PostModel> listRecordByCategory(Integer cate, Integer page, Integer size) {
		if (page != 0) {
			page = page + size;
		}
		List<PostModel> list = postDao.listRecordByCategory(cate, page, size);
		return list;
	}

	@Override
	public List<PostData> listPostData(List<PostModel> posts) {
		List<PostData> listPosts = new ArrayList<PostData>();
		for (PostModel post : posts) {
			PostData postData = new PostData();
			postData.setId(post.getId());
			postData.setTitle(post.getTitle());
			postData.setDescription(post.getDescription());
			postData.setContent(post.getContent());
			postData.setCreatedBy(post.getCreatedBy());
			postData.setCreated(post.getCreated());
			postData.setThumbnail(post.getThumbnail());
			CategoryModel cate = categoryService.findOneById(post.getCategoryId());
			postData.setCategory(cate);
			listPosts.add(postData);
		}
		return listPosts;
	}

	@Override
	public List<PostModel> searchByKey(String searchKey, Integer page, Integer size) {
		if (page != 0) {
			page = page + size;
		}
		return postDao.searchByKey(searchKey, page, size);
	}

	@Override
	public List<PostModel> listFavorite(Integer userId) {
		List<FavoriteArticles> favoriteArticles = postDao.listFavorite(userId);
		List<PostModel> posts = new ArrayList<PostModel>();
		for(FavoriteArticles favorite: favoriteArticles) {
			posts.add(postDao.findOne(favorite.getPostId()));
		}
		return posts;
	}

	@Override
	public Integer insertFavoriteArticles(Integer userId, Integer postId) {
		return postDao.insertFavoriteArticles(userId, postId);
	}

	@Override
	public Integer getFavoriteArticles(Integer userId, Integer postId) {
		return postDao.getFavoriteArticles(userId, postId);
	}

	@Override
	public void deleteFavoriteArticle(Integer userId, Integer postId) {
		postDao.deleteFavoriteArticle(userId, postId);
	}

}
