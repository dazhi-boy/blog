package com.dazhi.blogconsumer.blog.controller;

import com.dazhi.blogconsumer.base.service.UserService;
import com.dazhi.blogconsumer.blog.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog/theme")
public class ThemeController {

//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    ThemeService themeService;

    @GetMapping
    public String get() {
//        String str = restTemplate.getForObject("http://base-provider/base/user", String.class);
        String str = themeService.list();
        return str;
    }
}
