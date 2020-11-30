package hbv.com.ua.repository.mybatis;

import java.util.Optional;

public interface CRUD<T,ID> {
    void create(final T t);

    Optional<T> update (final T t, final ID id);

    Optional<T> read(final ID id);

    void delete(final ID id);
}
