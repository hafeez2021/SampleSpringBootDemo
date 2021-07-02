package com.dp.demo.contracts;

import java.util.List;

public interface QueryableRepository {
    void insert(String i);

    List<String> select();
}
