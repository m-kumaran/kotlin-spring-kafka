package com.mk.springkafkakotlin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class MessageController{

    @Autowired
    lateinit var producer: Producer

    @RequestMapping("/")
    fun showDashboard(modelAndView: ModelAndView):String{
        return "dashboard"
    }

}