package com.project.joblisting.repository;

import com.project.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> //data is of post type, and pk is String
{
    //we dont have write any methods or create class
    //which inplements this mongo repo will take care of crud.
}
