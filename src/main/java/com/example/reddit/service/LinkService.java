package com.example.reddit.service;

import com.example.reddit.domain.Link;
import com.example.reddit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> findAll(){
        return linkRepository.findAll();
    }
    public Optional<Link> findById(Long id){
        return linkRepository.findById(id);
    }
    public Link save(Link link){
        return linkRepository.save(link);
    }

}
