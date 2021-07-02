package com.dp.demo.implementation;

import com.dp.demo.contracts.PersistenceRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SqlPersistenceRepository  implements PersistenceRepository {

    List<String> enqeue = new ArrayList<>();
    List<String> db = new ArrayList<>();

    @Override
    public void insert(String i) {
        batchInsert(i);
    }


    public void batchInsert(String i) {
        enqeue.add(i);
        if(enqeue.size() == 50)
        {
            db.addAll(enqeue); // DB Operation
            enqeue.clear();
        }
    }

    public List<String> select() {

        List<String> dbValues = enqeue.stream().collect(Collectors.toList());;
        if(dbValues.size() == 0)
            dbValues = dbSelect();
        return dbValues;
    }

    private List<String> dbSelect()
    {
        return db.stream().collect(Collectors.toList());
    }

    @Override
    public void update(int index, String val) {
        String Val = db.get(index);
        db.remove(index);
        db.add(val);
    }
}
