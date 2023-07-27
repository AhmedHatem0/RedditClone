package com.example.reddit.controller;

import com.example.reddit.domain.Link;
import com.example.reddit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class LinkController {
    private static final Logger logger = LoggerFactory.getLogger(LinkController.class);

    LinkRepository linkRepository;
    public LinkController(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }
    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("links", linkRepository.findAll());
        return "link/list";
    }

    @GetMapping("link/{id}")
    public String read(@PathVariable Long id, Model model){
        Optional<Link> link = linkRepository.findById(id);
        if(link.isPresent()) {
            model.addAttribute("link", link.get());
            model.addAttribute("success", model.containsAttribute("success"));
            return "link/view";
        }
        else return "redirect:/";
    }
    @GetMapping("/link/submit")
    public String newLinkForm(Model model) {
        model.addAttribute("link",new Link());
        return "link/submit";
    }

    @PostMapping("/link/submit")
    public String createLink(@Valid Link link, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
         if (bindingResult.hasErrors()){
          logger.info("validation errors were found");
          model.addAttribute("link",link);
          return "link/submit";
        }
         else {
             linkRepository.save(link);
             model.addAttribute("id", link.getId());
             logger.info("new link saved successfully");
             redirectAttributes
                     .addAttribute("id",link.getId())
                     .addFlashAttribute("success", true);
             return "redirect:/link/{id}";
         }
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
