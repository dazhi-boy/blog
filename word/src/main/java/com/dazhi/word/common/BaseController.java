package com.dazhi.word.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    @GetMapping("/page/{current}/{size}")
    public Result<IPage<T>> page(@PathVariable("current") Long current, @PathVariable("size") Long size) {
        IPage<T> page = new Page<>(current, size);
        IPage<T> tPage = iService.page(page);
        Result<IPage<T>> result = Result.ok("OK");
        result.setData(tPage);
        return result;
    }

    @ApiOperation(value = "获取列表")
    @GetMapping("/page")
    public Result<List<T>> list() {
        List<T> list = iService.list();
        Result<List<T>> result = Result.ok("OK");
        result.setData(list);
        return result;
    }
}
