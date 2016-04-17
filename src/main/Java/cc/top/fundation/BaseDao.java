package cc.top.fundation;

import java.util.List;

/**
 * Created by Zus on 3/21/16.
 */
public interface BaseDao<T> {
    public void addOne(T t);
    public List<T> queryAll(T t);
    public void delete(String id);
    public void modify(T t);
    public T getById(String id);
}
