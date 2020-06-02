package com.hsalahud.subscriptionService.repositories;

import com.hsalahud.subscriptionService.Models.Subscriber;
import org.springframework.data.repository.CrudRepository;

public interface SubscriberRepository extends CrudRepository<Subscriber, Integer> {

    Subscriber findByName(String name);
    Subscriber findByEmail(String email);

}
