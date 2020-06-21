package com.delayed.dao.impl;

import java.util.List;

import com.delayed.dao.PostDao;
import com.delayed.mapper.FavoriteArticlesMapper;
import com.delayed.mapper.PostMapper;
import com.delayed.model.FavoriteArticles;
import com.delayed.model.PostModel;

public class PostDaoImpl extends ConnectionImpl<PostModel> implements PostDao {

	/**
	 * Insert record into database Save {@inheritDoc}
	 * 
	 * @see com.delayed.dao.PostDao#save(com.delayed.model.PostModel)
	 */
	@Override
	public Integer save(PostModel post) {
		StringBuilder sql = new StringBuilder("INSERT INTO post (title, description,");
		sql.append("content,created, created_by, category_id)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), post.getTitle(), post.getDescription(), post.getContent(), post.getCreated(),
				post.getCreatedBy(), post.getCategoryId());
	}

	/**
	 * Find all record {@inheritDoc}
	 * 
	 * @see com.delayed.dao.PostDao#findAll()
	 */
	@Override
	public List<PostModel> findAll() {
		String sql = "SELECT * FROM post ORDER BY created DESC";
		return query(sql, new PostMapper());
	}

	/**
	 * find one record {@inheritDoc}
	 * 
	 * @see com.delayed.dao.PostDao#findOne(java.lang.Long)
	 */
	@Override
	public PostModel findOne(Integer id) {
		if (id != null) {
			String sql = "SELECT * FROM post WHERE id = ?";
			List<PostModel> news = query(sql, new PostMapper(), id);
			return news.isEmpty() ? null : news.get(0);
		}
		return null;
	}

	/**
	 * Update record by id {@inheritDoc}
	 * 
	 * @see com.delayed.dao.PostDao#update(com.delayed.model.PostModel)
	 */
	@Override
	public void update(PostModel post) {
		StringBuilder sql = new StringBuilder("UPDATE post SET title = ?,");
		sql.append(" description = ?, content = ?,");
		sql.append("updated = ?, updated_by = ?, category_id = ? WHERE id = ?");
		update(sql.toString(), post.getTitle(), post.getDescription(), post.getContent(), post.getUpdated(),
				post.getUpdatedBy(),post.getCategoryId(), post.getId());
	}

	/**
	 * Delete multiple record by ids {@inheritDoc}
	 * 
	 * @see com.delayed.dao.PostDao#deleteById(java.lang.String)
	 */
	@Override
	public void deleteById(Integer id) {
		String sql = "DELETE FROM post WHERE id=" + id;
		update(sql);
	}

	@Override
	public List<PostModel> findRecordLimit(Integer limit) {
		String sql = "SELECT * FROM post LIMIT " + limit;
		return query(sql, new PostMapper());
	}

	@Override
	public List<PostModel> listRecord(Integer page, Integer size) {
		String sql = "SELECT * FROM post LIMIT " + page + "," + size;
		return query(sql, new PostMapper());
	}

	@Override
	public List<PostModel> findPostMostViewed() {
		String sql = "SELECT * FROM post ORDER BY views DESC LIMIT 5";
		return query(sql, new PostMapper());
	}

	@Override
	public List<PostModel> listRecordByCategory(Integer cate, Integer page, Integer size) {
		String sql = "SELECT * FROM post WHERE category_id = " + cate + " LIMIT " + page + "," + size;
		return query(sql, new PostMapper());
	}

	@Override
	public List<PostModel> searchByKey(String searchKey, Integer page, Integer size) {
		String sql = "SELECT * FROM post WHERE title LIKE '%" + searchKey + "%' LIMIT " + page + "," + size;
		return query(sql, new PostMapper());
	}

	@Override
	public List<FavoriteArticles> listFavorite(Integer id) {
		String sql = "SELECT * FROM favoritearticles WHERE user_id=" + id;
		return query(sql, new FavoriteArticlesMapper());
	}

	@Override
	public Integer insertFavoriteArticles(Integer userId, Integer postId) {
		StringBuilder sql = new StringBuilder("INSERT INTO favoritearticles (user_id, post_id)");
		sql.append(" VALUES(?, ?)");
		return insert(sql.toString(), userId, postId);
	}

	@Override
	public Integer getFavoriteArticles(Integer userId, Integer postId) {
		String sql = "SELECT COUNT(post_id) FROM favoritearticles WHERE user_id=? AND post_id=?";
		return count(sql, userId, postId);
	}

	@Override
	public void deleteFavoriteArticle(Integer userId, Integer postId) {
		String sql = "DELETE FROM favoritearticles WHERE user_id=? AND post_id=?";
		update(sql, userId, postId);
	}

}
