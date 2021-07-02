package com.dp.demo.contracts;

import java.util.List;

public interface PersistenceRepository extends QueryableRepository  {
    void batchInsert(String i);
    void update(int index, String val);
}

