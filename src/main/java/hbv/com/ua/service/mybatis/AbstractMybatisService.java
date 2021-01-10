package hbv.com.ua.service.mybatis;

import hbv.com.ua.exception.global.handler.UncaughtExceptionHandlerImpl;
import hbv.com.ua.repository.mybatis.CRUD;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public abstract class AbstractMybatisService< T, ID, R extends CRUD< T, ID > > {
	protected R repository;

	public AbstractMybatisService( R repository ) {
		this.repository = repository;
	}

	public void create( T t ) {
		CompletableFuture.runAsync( ( ) -> {
			repository.create( t );
		} ).join( );
	}

	public T update( T t, ID id ) throws ExecutionException, InterruptedException, NotFoundException {
		return CompletableFuture.supplyAsync( ( ) -> {
			return repository.update( t, id );
		} ).join( ).orElseThrow( ( ) -> new NotFoundException( "Entity by id: %d has been not found" ) );
	}

	public T read( ID id ) throws ExecutionException, InterruptedException, NotFoundException {
		return CompletableFuture.supplyAsync( ( ) -> {
			return repository.read( id );
		} ).join( ).orElseThrow( ( ) -> new NotFoundException( "Entity by id: %d has been not found" ) );
	}

	public void delete( ID id ) {
		CompletableFuture.runAsync( ( ) -> {
			repository.delete( id );
		} ).join();
	}
}
