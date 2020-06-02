package com.hsalahud.subscriptionService.controllers;

import com.hsalahud.subscriptionService.Models.Subscriber;
import com.hsalahud.subscriptionService.repositories.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ThymeSubscriptionController {
    @Autowired
    private SubscriberRepository subscriberRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/subscribe")
    public String getAllSubscribers(Model model) {
        model.addAttribute("subscriber", new Subscriber());
        model.addAttribute("subscribers", subscriberRepository.findAll());
        return "subscribe";
    }

    @PostMapping("/subscribe")
    public String addSubscriber(@ModelAttribute("subscriber") Subscriber subscriber, Model model){
        subscriberRepository.save(subscriber);
        return "thankyou";
    }

    @PostMapping("/unsubscribe/{id}")
    public String deleteSubscriber(@PathVariable String id) {
        subscriberRepository.deleteById(Integer.parseInt(id));
        return "redirect:/subscribers";
    }

    @GetMapping("/subscribers")
    public String manageAllSubscribers(Model model) {
        model.addAttribute("subscriber", new Subscriber());
        model.addAttribute("subscribers", subscriberRepository.findAll());
        return "subscribers";
    }

    @GetMapping("/unsubscribe")
    public String getAllSubscribersToDelete(Model model) {
        model.addAttribute("subscriber", new Subscriber());
        model.addAttribute("subscribers", subscriberRepository.findAll());
        return "unsubscribe";
    }

    @PostMapping("/unsubscribe")
    public String deleteSubscriber (@ModelAttribute("subscriber") Subscriber subscriber) {
        Subscriber sub = subscriberRepository.findByEmail(subscriber.getEmail());
        subscriberRepository.deleteById(sub.getId());
        return "sorrytoseeyougo";
    }

}
