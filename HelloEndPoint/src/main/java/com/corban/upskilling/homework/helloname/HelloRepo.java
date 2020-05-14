package com.corban.upskilling.homework.helloname;

import org.json.JSONObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepo extends CrudRepository<Name, Long> {
}
