package com.prometheus.workflow.config;

import com.prometheus.workflow.enums.Events;
import com.prometheus.workflow.enums.States;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class SimpleStateMachineConfiguration extends StateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states
                .withStates()
                .initial(States.AWAITING)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
                .withExternal()
                .source(States.AWAITING).target(States.CHECKING).event(Events.UNIT_ARRIVED)
                .and()
                .withExternal()
                .source(States.CHECKING).target(States.PROCCESSING_ALLOWED_NUMBER).event(Events.NUMBER_ALLOWED)
                .and()
                .withExternal()
                .source(States.CHECKING).target(States.PROCCESSING_FORBIDEN_NUMBER).event(Events.NUMBER_FORBIDEN)
                .and()
                .withExternal()
                .source(States.PROCCESSING_ALLOWED_NUMBER).target(States.AWAITING).event(Events.IN_AWAITING)
                .and()
                .withExternal()
                .source(States.PROCCESSING_FORBIDEN_NUMBER).target(States.AWAITING).event(Events.IN_AWAITING);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(new StateMachineListenerAdapter<States, Events>() {
                    @Override
                    public void stateChanged(org.springframework.statemachine.state.State<States, Events> from, org.springframework.statemachine.state.State<States, Events> to) {
                        super.stateChanged(from, to);
                        System.out.printf("Transitioned from %s to %s%n", from == null ? "none" : from.getId(), to.getId());
                    }

                    /*@Override
                    public void stateChanged(State<States, Events> from, State<States, Events> to) {
                        System.out.printf("Transitioned from %s to %s%n", from == null ? "none" : from.getId(), to.getId());
                    }*/
                });

    }

    /*@Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states
                .withStates()
                .initial(States.STAGE1)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
                .withExternal()
                .source(States.STAGE1).target(States.STAGE2).event(Events.GO_TO_STAGE2)
                .and()
                .withExternal()
                .source(States.STAGE2).target(States.STAGE3).event(Events.GO_TO_STAGE3)
                .and()
                .withExternal()
                .source(States.STAGE3).target(States.STAGE1).event(Events.END);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(new StateMachineListenerAdapter<States, Events>() {
                    @Override
                    public void stateChanged(org.springframework.statemachine.state.State<States, Events> from, org.springframework.statemachine.state.State<States, Events> to) {
                        super.stateChanged(from, to);
                        System.out.printf("Transitioned from %s to %s%n", from == null ? "none" : from.getId(), to.getId());
                    }

                    *//*@Override
                    public void stateChanged(State<States, Events> from, State<States, Events> to) {
                        System.out.printf("Transitioned from %s to %s%n", from == null ? "none" : from.getId(), to.getId());
                    }*//*
                });

    }*/
}
