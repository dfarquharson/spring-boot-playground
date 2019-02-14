package io.dfarquharson.app.model;

import org.junit.Test;

import java.util.UUID;

public class CoolThingTest {

    @Test
    public void makeThing() {
        CoolThing coolThing = ImmutableCoolThing.builder()
            .id(1L)
            .uuid(UUID.randomUUID())
            .name("hughbert")
            .story("really cool")
            .build();
        System.out.println(coolThing);
    }

}