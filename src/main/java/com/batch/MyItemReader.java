package com.batch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;

@Named("myItemReader")
public class MyItemReader extends AbstractItemReader {

    private List<Person> list ;
    private Integer index;

    @Override
    public void open(Serializable checkpoint) throws Exception {

        list = new ArrayList<>();
        index = 0; 

        for(int i = 0; i < 10; i++){
            list.add(new Person(213, "ASDF", "asdfasd"));
            
            try {
                Thread.currentThread().sleep(1000l);
                
            } catch (InterruptedException e) {
                
            }
        }
    }

    @Override
    public Person readItem() {
        Person person = null;
        try {
            if(index < 10){

                person = list.get(index);
                                
                index++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            // Logger.getLogger(MyItemReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }
}
