package com.example.demo.repository;

import com.example.demo.entity.DemoEntity;

//Acting as a Spring library
public interface DemoRepository {
    default void foo(final DemoEntity entity) {
        throw new RuntimeException("You must not reach this part");
    }
}
