package io.dfarquharson.app.service;

import io.dfarquharson.app.model.CoolThing;
import io.dfarquharson.app.model.ImmutableCoolThing;
import io.dfarquharson.app.service.base.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Service
public class CoolService implements Service<CoolThing> {

    private static List<CoolThing> data = List.of(
        ImmutableCoolThing.builder()
            .id(1L)
            .uuid(UUID.randomUUID())
            .name("Cool Thing 1")
            .build(),
        ImmutableCoolThing.builder()
            .id(2L)
            .uuid(UUID.randomUUID())
            .name("Cool Thing 2")
            .build()
    );

    @Override
    public List<CoolThing> list() {
        return data;
    }

    @Override
    public Optional<CoolThing> byId(Long id) {
        return data.stream().filter(it -> it.getId().equals(id)).findFirst();
    }

    @Override
    public CoolThing create(CoolThing thing) {
        data.add(thing);
        return thing;
    }

    @Override
    public CoolThing update(CoolThing thing) {
        if (data.contains(thing)) {
            data.add(data.indexOf(thing), thing);
        } else {
            data.add(thing);
        }
        return thing;
    }

}
