package com.thomasxiang.spring.springBootFirstProject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface photoRepository extends CrudRepository <Photo, Integer> {

}
