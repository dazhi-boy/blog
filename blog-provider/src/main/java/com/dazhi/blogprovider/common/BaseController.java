package com.dazhi.blogprovider.common;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;

public class BaseController<T,E extends IService<T>> {
    protected IService iService;

    @Resource
    public void setiService(E iService) {
        this.iService = iService;
    }

    @ApiOperation(value = "添加")
    @PostMapping
    public Result save(@RequestBody T t) {
        boolean res = iService.save(t);
        return Result.ok("OK", res);
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public Result update(@RequestBody T t) {
        boolean res = iService.updateById(t);
        return Result.ok("OK", res);
    }

    @ApiOperation(value = "通过id删除指定数据")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Long id) {
        boolean res = iService.removeById(id);
        return Result.ok("OK", res);
    }

    @ApiOperation(value = "通过id获取entity")
    @GetMapping("/{id}")
    public Result<T> get(@PathVariable("id") Long id) {
        T t = (T) iService.getById(id);
        Result<T> result = Result.ok("OK");
        result.setData(t);
        return result;
    }

    @ApiOperation(value = "获取列表")
    @GetMapping
    public Result<IPage<T>> list() {
        IPage<T> page = new Page<>();
        IPage<T> tPage = iService.page(page);
        // List<User> list = userService.list();
        Result<IPage<T>> result = Result.ok("OK");
        result.setData(tPage);
        return result;
    }
}
