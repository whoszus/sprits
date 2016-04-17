package cc.top.fundation.BASEDAO;

import cc.top.fundation.BaseDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Zus on 3/21/16.
 */
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {


    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    protected <S> S getMapper(Class<S> clazz) {
        return getSqlSession().getMapper(clazz);
    }

    /*
       通过反射获取class
       为了在getsqlsession.selectOne("org.mybatis.spring.sample.mapper.UserMapper.getUser",user)可以直接传实体进来;

     */
    public String getClassName(){
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
        return clazz.getSimpleName().toString().toLowerCase();
    }

    public void addOne(T t){
        getSqlSession().insert(this.getClassName()+".add",t);
    }

    public void delete(String id) {
        getSqlSession().delete(this.getClassName()+".deleteById",id);
    }
    @SuppressWarnings("unchecked")
    public T getById(String id) {
        return (T)getSqlSession().selectOne(this.getClassName()+".getById",id);
    }
    public void modify(T t) {
        getSqlSession().update(this.getClassName()+".update",t);
    }
    public List<T> queryAll(T t) {
        return getSqlSession().selectList(this.getClassName()+".queryAll",t);
    }



}
