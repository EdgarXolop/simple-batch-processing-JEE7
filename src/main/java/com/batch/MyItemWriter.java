package com.batch;

import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;

@Named("myItemWriter")
public class MyItemWriter extends AbstractItemWriter {

    @Override
    public void writeItems(List list) {
        System.out.println("writeItems: " + list);
        
        for(Object t : list){

            Person p = (Person)(t);

            System.out.println("======"+p.getId());
            System.out.println("======"+p.getName());
            System.out.println("======"+p.getHiredate());
        }
        
    }
}
