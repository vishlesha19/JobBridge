package com.project.joblisting.repository;
import java.util.List;
import com.project.joblisting.model.Post;

//creating new interface
public interface SearchRepository {

    //but this method is not present in mongodb fetures so we have to implement this in our class
    //we have created class called searchrepositoryImpl
    List<Post> findByText(String text);
}
