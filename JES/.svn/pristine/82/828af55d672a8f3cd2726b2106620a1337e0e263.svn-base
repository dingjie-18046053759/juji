package com.fmcq.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.fmcq.dao.BaseDao;
import com.fmcq.util.HibernateUtil;

/**
 * 类描述：@param <T>基础数据操作实现类，通过泛型无须一张表对应一个Dao
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource
	private HibernateUtil util;
	
	@Override
	public Serializable save(T t) {
		return util.save(t);
	}

	@Override
	public boolean update(T t) {
		// TODO Auto-generated method stub
		return util.update(t);
	}

	@Override
	public T get(String hql, Object... pras) {
		System.err.println(hql);
		return util.queryUnique(hql, pras);
	}

	@Override
	public Long count(String hql, Object... pras) {
		// TODO Auto-generated method stub
		return util.getCount(hql, pras);
	}

	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return util.delete(t);
	}

	@Override
	public boolean delete(Class<T> cla, Serializable id) {
		T obj=get(cla, id);
		if(obj!=null)
			return util.delete(obj);
		return false;
	}

	@Override
	public T get(Class<T> cla, Serializable id) {
		// TODO Auto-generated method stub
		return util.get(cla, id);
	}

	@Override
	public List<T> queryByHQL(String hql, Boolean isCach, Object... pras) {
		// TODO Auto-generated method stub
		return util.queryHQL(hql, isCach, pras);
	}

	@Override
	public List<T> queryBySQL(String sql, Class<T> cla, Boolean isCach,
			Object... pras) {
		// TODO Auto-generated method stub
		return util.queryBySQL(cla, sql, isCach, pras);
	}

	@Override
	public List<T> queryByHQLForPage(String hql, Boolean isCach, int page,
			int size, Object... pras) {
		// TODO Auto-generated method stub
		return util.queryHQLByPage(hql, isCach, page, size, pras);
	}

	@Override
	public List<T> queryBySQLForPage(String sql, Boolean isCach, Class<T> cla,
			int page, int size, Object... pras) {
		// TODO Auto-generated method stub
		return util.queryBySQLForPage(cla, sql, isCach, page, size, pras);
	}

	@Override
	public int batchUpdate(String hql, Object... pras) {
		// TODO Auto-generated method stub
		return util.updateBatch(hql, pras);
	}
	
	@Override
	public List<Object[]> queryListBySql(String sql) {
		return util.getSession().createSQLQuery(sql).list();
	}
	
	@Override
	public int execSql(String sql) {
		return util.getSession().createSQLQuery(sql).executeUpdate();
	}
}
