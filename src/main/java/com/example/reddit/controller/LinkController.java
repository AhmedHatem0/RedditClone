package com.example.reddit.controller;

import com.example.reddit.domain.Link;
import com.example.reddit.repository.LinkRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LinkController {
    LinkRepository linkRepository;
    public LinkController(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }
    @GetMapping("/")
    public String list(){
//        model.addAttribute("links", linkRepository.findAll());
        return "layout/new_page";
    }


    // CRUD

//    @PostMapping("/create")
//    public Link create(Link link) {
//        return linkRepository.save(link);
//    }
//    @GetMapping("/{id}")
//    public Optional<Link> read(@PathVariable Long id) {
//        return linkRepository.findById(id);
//    }
//    @PutMapping("/{id}")
//    public Link update(@PathVariable Long id, @ModelAttribute Link link) {
//        //find the specific link by the id, edit it and save it back
//        return linkRepository.save(link);
//    }
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//         linkRepository.deleteById(id);
//    }
}
