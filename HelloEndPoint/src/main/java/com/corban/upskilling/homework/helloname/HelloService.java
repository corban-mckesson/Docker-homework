package com.corban.upskilling.homework.helloname;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService {

    @Autowired
    private HelloRepo helloRepo;

    public List<Name> findAll(){
        ArrayList<Name> names = new ArrayList<Name>();
        for(Name name: helloRepo.findAll()){
            System.out.println(name.toString());
            names.add(name);
        }
        return names;
    }

    public Long count(){
        return helloRepo.count();
    }

    public String addName(Name name){
        helloRepo.save(name);
        return name.toString();
    }
}
