package com.example.reddit;

import com.example.reddit.domain.Comment;
import com.example.reddit.domain.Link;
import com.example.reddit.repository.CommentRepository;
import com.example.reddit.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RedditApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedditApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
        return args -> {
        Link link = new Link("description of link 1", "urloflink1.com");
        linkRepository.save(link);
        Comment comment = new Comment("body of comment 1 on link 1", link);
        commentRepository.save(comment);
        link.addComment(comment);
        };
    }

}
