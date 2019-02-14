package io.dfarquharson.app.controller.base;

import io.dfarquharson.app.model.base.MetaThing;
import io.dfarquharson.app.service.base.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public abstract class HttpCrudController<T extends MetaThing, SERVICE extends Service<T>> {

    protected final SERVICE service;

    protected HttpCrudController(SERVICE service) {
        this.service = service;
    }

    @GetMapping
    public List<T> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public T byId(@PathVariable("id") Long id) {
        return service.byId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public T create(T t) {
        return service.create(t);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable("id") Long id, T t) {
        return service.update(t);
    }

}
