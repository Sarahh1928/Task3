package com.example.Task_3.services;

import com.example.Task_3.models.Comment;
import com.example.Task_3.models.Post;
import com.example.Task_3.repositories.PostRepository;
import com.example.Task_3.repositories.UserRepository;
import com.mongodb.client.MongoClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private UserRepository userRepository;


    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;

        this.userRepository = userRepository;
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(String id) {
        return postRepository.findById(id);
    }

    public void deletePost(String id) {
        postRepository.deleteById(id);
    }

    //Get Posts By Author ID
    public List<Post> getPostsByAuthorID(String authorID) {
        if (!userRepository.existsById(authorID)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
        }
        return postRepository.findByAuthorId(authorID);
    }

    //Add Comment to Post
    public Post addCommentToPost(String postID, Comment newComment) {
        return postRepository.findById(postID)
                .map(post -> {
                    post.getComments().add(newComment);
                    return postRepository.save(post);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));
    }

}
