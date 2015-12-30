package cc.top.fundation.base;
import cc.top.fundation.utils.PageView;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 返回分页后的数据
	 * @param pageView
	 * @param t
	 * @return
	 */
	public List<T> query(PageView pageView, T t);
	/**
	 * 返回所有数据
	 * @param t
	 * @return
	 */
	public List<T> queryAll(T t);
	public void delete(String id);
	public void modify(T t);
	public T getById(String id);
	public void add(T t);
}
