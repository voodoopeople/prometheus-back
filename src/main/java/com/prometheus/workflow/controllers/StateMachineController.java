package com.prometheus.workflow.controllers;

import com.prometheus.workflow.enums.Events;
import com.prometheus.workflow.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StateMachineController {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @GetMapping("/sendEvent")
    public String sendEvent(@RequestParam("event") Events event) {
        stateMachine.sendEvent(event);
        return "Event sent: " + event;
    }
}
