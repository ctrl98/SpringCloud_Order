package org.lee.repository;

import org.lee.entity.Type;

import java.util.List;

public interface TypeRepository {
    Type findById(long id);

    List<Type> findAll();
}
