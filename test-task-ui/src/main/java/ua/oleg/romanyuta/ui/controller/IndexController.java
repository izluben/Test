package ua.oleg.romanyuta.ui.controller;

import ua.oleg.romanyuta.dao.AuthorRepository;
import ua.oleg.romanyuta.dao.ClaimRepository;
import ua.oleg.romanyuta.domain.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


@Controller
public class IndexController {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("claims", claimRepository.findAll());
        modelAndView.addObject("newClaim", new Claim());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value={"/new_claim","edit_claim/{claimId}"})
    public ModelAndView addClaim(ModelAndView modelAndView, @PathVariable(value = "claimId", required = false) Long claimId) {
        if(claimId != null) {
            Claim claim = claimRepository.findOne(claimId);
            modelAndView.addObject("claim", claim);
        } else {
            modelAndView.addObject("claim", new Claim());
        }
        modelAndView.setViewName("addClaim");
        return modelAndView;
    }

    @PostMapping(value="/new_claim")
    public String addClaim(Claim newClaim) {
        if(newClaim.getId() == null) {
            newClaim.setCreationDate(Date.from(LocalDateTime.now().atZone(ZoneOffset.systemDefault()).toInstant()));
        } else {
            Claim existed = claimRepository.findOne(newClaim.getId());
            existed.setTitle(newClaim.getTitle());
            existed.setDescription(newClaim.getDescription());
            newClaim = existed;
        }
        claimRepository.save(newClaim);
        return "redirect:/";
    }
}
