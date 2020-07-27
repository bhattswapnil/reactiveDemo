package com.example.reacitvespring.reacitvespring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class ReacitvespringApplication

	fun main(args: Array<String>) {
		val sa = SpringApplication()
			sa.addListeners(SpringApplicationListner())
		runApplication<ReacitvespringApplication>(*args)
	}



