package com.prometheus.workflow.service;

import org.springframework.statemachine.annotation.OnStateEntry;
import org.springframework.statemachine.annotation.OnStateExit;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class StateMachineActions {

    @OnStateEntry(target = "STAGE1")
    public void toStage1() {
        System.out.println("Entering Stage 1");
    }

    @OnStateEntry(target = "STAGE2")
    public void toStage2() {
        System.out.println("Entering Stage 2");
    }

    @OnStateEntry(target = "STAGE3")
    public void toStage3() {
        System.out.println("Entering Stage 3");
    }

    @OnStateExit(source = "STAGE1")
    public void fromStage1() {
        System.out.println("Exiting Stage 1");
    }

    @OnStateExit(source = "STAGE2")
    public void fromStage2() {
        System.out.println("Exiting Stage 2");
    }

    @OnStateExit(source = "STAGE3")
    public void fromStage3() {
        System.out.println("Exiting Stage 3");
    }
}
