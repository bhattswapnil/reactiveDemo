package com.example.reacitvespring.reacitvespring

import com.example.reacitvespring.reacitvespring.Identifier
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class Reference<Class>(
        //val id: String? = null,
        var reference: String? = null,
        var type: String? = null,
        var identifier: Identifier? = null
) {


}