package com.project.joblisting.controller;

import com.project.joblisting.repository.PostRepository;
import com.project.joblisting.model.Post;
import com.project.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


//in spring framework we use spring mvc i.e model view controller
//here we created this file as controller using @RestController

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    //for every request we will write methods here
    //eg post, get

    //behind the scene they will create a class for this interfaace called repo
    @Autowired  //spring will create ojecr and will map it
    PostRepository repo;

    @Autowired
    SearchRepository srepo;


    @ApiIgnore    //to ignore the options that we get by default in swagger api
    //enable swagger
    @RequestMapping(value="/") //when someone try to access home page then open swagger api
    public void redirect(HttpServletResponse response) throws IOException
    {
        response.sendRedirect("/swagger-ui.html");
    }

    //we want a url which request all the posts i.e data of jobs
    @GetMapping("/allPosts")
    //on swagger we want option to fetch all the post for that we doing mapping
    @CrossOrigin
    public List<Post> getAllPosts()
    {
        return repo.findAll();  //findall() is inbuilt method of ongorepository
    }

    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text)
    {
        return srepo.findByText(text);
    }

    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }
}
