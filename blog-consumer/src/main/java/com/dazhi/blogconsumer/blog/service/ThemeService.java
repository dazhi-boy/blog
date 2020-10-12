package com.dazhi.blogconsumer.blog.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "blog-provider")
public interface ThemeService {
    @GetMapping("/blog/theme")
    String list();
}
