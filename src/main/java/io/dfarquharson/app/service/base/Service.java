package io.dfarquharson.app.service.base;

import java.util.List;
import java.util.Optional;

public interface Service<T> {

    List<T> list();

    Optional<T> byId(Long id);

    T create(T t);

    T update(T t);

}
