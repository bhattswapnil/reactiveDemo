package com.example.demo

import org.bson.types.Code
import java.text.DecimalFormat
import java.time.ZonedDateTime

class Timing(
        val count:Int?= null,
        val countMax:Int?= null,
        val duration:Int?= null,
        val durationUnit:Code? =null,
        val frequency:Int?= null,
        val frequencyMax:Int?= null,
        val period:Float?= null,
        val periodUnit:Char? =null
)