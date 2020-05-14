package com.corban.upskilling.homework.helloname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("hello/{name}")
    public String sayHelloPlusName(@PathVariable("name") String name){
        JSONObject helloJson = new JSONObject();
        helloJson = helloJson.put("Hello", name);
        Name myName = new Name(helloJson);
        helloService.addName(myName);

        return helloJson.toString();
    }

    @RequestMapping("names/")
    public String sayNamesFromDB(){
        ArrayList<String> stringNames = new ArrayList<String>();

        for(Name nameFromService: helloService.findAll()){
            stringNames.add(nameFromService.getNameString());
        }

        return stringNames.toString();
    }

}
