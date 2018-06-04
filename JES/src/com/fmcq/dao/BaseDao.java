package com.fmcq.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @category 数据库操作基础接口
 */
public interface BaseDao<T> {
	
	/**
	 * @param t要保存的实体对象
	 * @return添加对象，返回当前记录的主键值
	 */
	public Serializable save(T t);
	
	/**
	 * @param t要删除实体的对象
	 * @return 删除对象，返回是否删除成功
	 */
	public boolean delete(T t);
	/**
	 * @param cla封装类的类型
	 * @param id 主键
	 * @return 删除对象，返回是否删除成功
	 */
	public boolean delete(Class<T> cla,Serializable id);
		
	/**
	 * @param t要修改的实体对象
	 * @return 修改数据，返回是否修改成功
	 */
	public boolean update(T t);
	
	/**
	 * @param hql语句如：delete User where userid=?
	 * @param pras HQL语句中参数的值
	 * @return 批量更新和删除数据，返回更新的记录数量
	 */
	public int batchUpdate(String hql,Object...pras);
	
	/**
	 * @param cla封装类的类型
	 * @param id 主键
	 * @return 根据主键ID获取对象
	 */
	public T get(Class<T> cla,Serializable id);
	
	
	/**
	 * @param hql
	 * @param pras
	 * @return 根据多条件查询返回唯一的一条数据
	 */
	public T get(String hql,Object...pras);
	
	
	/**
	 * @param hql语句
	 * @param isCach参数是否缓存数据，真为缓存，假不缓存
	 * @param pras参数值
	 * @return 使用HQL语句查询一条及以上的数据
	 */
	public List<T> queryByHQL(String hql,Boolean isCach,Object...pras);
	
	/**
	 * @param sql语句
	 * @param cla集合中的封装类的类型
	 * @param isCach参数是否缓存数据，真为缓存，假不缓存
	 * @param pras参数值
	 * @return 使用SQL语句查询一条及以上的数据
	 */
	public List<T> queryBySQL(String sql,Class<T> cla,Boolean isCach,Object...pras);
		
	/**
	 * @param hql语句
	 * @param isCach参数是否缓存数据，真为缓存，假不缓存
	 * @param page页数
	 * @param size每页记录个数
	 * @param pras参值数
	 * @return 使用HQL分页查询数据
	 */
	public List<T> queryByHQLForPage(String hql,Boolean isCach,int page,int size,Object...pras);
	
	
	/**
	 * @param sql语句
	 * @param isCach参数是否缓存数据，真为缓存，假不缓存
	 * @param cla集合中的封装类的类型
	 * @param page页数
	 * @param size记录数
	 * @param pras参数值
	 * @return 使用SQL语句分页查询数据，建议使用HQL，更换数据库会出错的可能
	 */
	public List<T> queryBySQLForPage(String sql,Boolean isCach,Class<T> cla,int page,int size,Object...pras);
	
	
	/**
	 * @param hql
	 * @param pras
	 * @return 返回统计数据的数量
	 */
	public Long count(String hql,Object...pras);

	/**
	 * 根据sql查询出数据
	 * @param sql
	 * @return
	 */
	public List<Object[]> queryListBySql (String sql); 

	/**
	 * 执行原生Sql
	 * @param sql
	 * @return
	 */
	public int execSql (String sql);
}
