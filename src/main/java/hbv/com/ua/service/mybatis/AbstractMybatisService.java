package hbv.com.ua.service.mybatis;

import hbv.com.ua.repository.mybatis.CRUD;

public abstract class AbstractMybatisService<T,ID, R extends CRUD<T,ID>> {
    protected R repository;

    public AbstractMybatisService(R repository) {
        this.repository = repository;
    }

    public void create(T t) {

    }

    public T update(T t, ID id){
        return null;
    }

    public T read(ID id) {
        return null;
    }

    public void delete(ID id) {

    }
}
