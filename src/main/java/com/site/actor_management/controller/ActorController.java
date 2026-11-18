package com.site.actor_management.controller;

import com.site.actor_management.model.Actor;
import com.site.actor_management.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActorController {
    @Autowired
    private ActorService actorService;

    // READ ALL

    @GetMapping("/actors")
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    //READ BY ID

    @GetMapping("/actor/{id}")
    public Actor getActorById(@PathVariable long id) {
        return actorService.getActorById(id);
    }

    // CREATE

    @PostMapping("/actor")
    public Actor createActor(@RequestBody Actor actor) {
        return actorService.createActor(actor);
    }

    // UPDATE

    @PutMapping("/actor/{id}")
    public Actor updateActor(@PathVariable Long id, @RequestBody Actor actor) {
        return actorService.updateActor(id, actor);
    }

    @PatchMapping("/actor/{id}")
    public Actor patchActor(@PathVariable Long id, @RequestBody Actor actor) {
        return actorService.patchActor(id, actor);
    }

    // DELETE

    @DeleteMapping("/actor/{id}")
    public String deleteActor(@PathVariable Long id) {
        return actorService.deleteActor(id);
    }
}
