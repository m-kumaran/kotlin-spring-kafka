package com.mk.dashboard

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class DashboardController {

    @RequestMapping("/")
    fun showDashboard(modelAndView: ModelAndView): String {
        return "dashboard"
    }

}