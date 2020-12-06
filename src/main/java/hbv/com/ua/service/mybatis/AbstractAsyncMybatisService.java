package hbv.com.ua.service.mybatis;

import hbv.com.ua.repository.mybatis.CRUD;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public abstract class AbstractAsyncMybatisService<T, ID, R extends CRUD<T, ID>> {
    protected R repository;

    public AbstractAsyncMybatisService(R repository) {
        this.repository = repository;
    }

    public void create(T t) {
        CompletableFuture
                .runAsync(() -> repository.create(t));
    }

    public T update(T t, ID id) throws ExecutionException, InterruptedException, NotFoundException {
        return CompletableFuture
                .supplyAsync(() -> repository.update(t, id))
                .get()
                .orElseThrow(() -> new NotFoundException(String.format("entity cannot update by id %d", id)));
    }

    public T read(ID id) throws ExecutionException, InterruptedException, NotFoundException {
        return CompletableFuture
                .supplyAsync(() -> repository.read(id))
                .get()
                .orElseThrow(() -> new NotFoundException(String.format("entity cannot update by id %d", id)));
    }

    public void delete(ID id) {
        CompletableFuture
                .runAsync(() -> repository.delete(id));
    }
}
