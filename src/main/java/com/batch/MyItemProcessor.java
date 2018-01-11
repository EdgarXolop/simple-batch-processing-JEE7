package com.batch;

import java.text.SimpleDateFormat;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named("myItemProcessor")
public class MyItemProcessor implements ItemProcessor {
    private static int id = 1;
    private SimpleDateFormat format = new SimpleDateFormat("M/dd/yy");

    @Override
    public Person processItem(Object t) {
        System.out.println("processItem: " + t);
        Person p = (Person)(t);

        System.out.println("======"+p.getId());
        System.out.println("======"+p.getName());
        System.out.println("======"+p.getHiredate());

        return p;
    }
}
