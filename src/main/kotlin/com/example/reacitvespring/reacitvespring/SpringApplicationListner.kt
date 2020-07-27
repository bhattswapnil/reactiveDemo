package com.example.reacitvespring.reacitvespring

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener

class SpringApplicationListner : ApplicationListener<ApplicationReadyEvent> {

    internal var firstTime = true;
    override fun onApplicationEvent(contextRefreshedEvent: ApplicationReadyEvent) {
        if(firstTime)
            firstTime = false

    }
}