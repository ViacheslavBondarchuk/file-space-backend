package hbv.com.ua.service.mybatis;

import hbv.com.ua.repository.mybatis.CRUD;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public abstract class AbstractMybatisService<T, ID, R extends CRUD<T, ID>> {
    protected R repository;

    public AbstractMybatisService(R repository) {
        this.repository = repository;
    }

    public AbstractMybatisService() {
    }

    public void create(T t) {
        CompletableFuture.runAsync(() -> repository.create(t));
    }

    public T update(T t, ID id) throws ExecutionException, InterruptedException, NotFoundException {
        return CompletableFuture.supplyAsync(() -> repository.update(t, id))
                .get()
                .orElseThrow(() -> new NotFoundException("Entity by id: %d has been not found"));
    }

    public T read(ID id) throws ExecutionException, InterruptedException, NotFoundException {
        return CompletableFuture.supplyAsync(() -> repository.read(id))
                .get()
                .orElseThrow(() -> new NotFoundException("Entity by id: %d has been not found"));
    }

    public void delete(ID id) {
        CompletableFuture.runAsync(() -> repository.delete(id));
    }
}
