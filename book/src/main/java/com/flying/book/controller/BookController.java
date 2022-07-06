package com.flying.book.controller;

import com.flying.book.controller.vo.BookVO;
import com.flying.book.core.OnlyAdmin;
import com.flying.book.core.exception.ParameterInvalidException;
import com.flying.book.core.web.AjaxResult;
import com.flying.book.domain.Book;
import com.flying.book.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Api(tags = "图书信息")
@RestController
@RequestMapping("/book")
public class BookController {
    @Value("${biz.config}")
    String profileNamespace;

    @Autowired
    private BookService service;

    @RequestMapping(value = "/ok", method = RequestMethod.GET)
    public String ok(){
        return "{ok}";
    }

    @ApiOperation(value = "按id查询", notes = "通过图书id进行查询")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AjaxResult findById(@PathVariable Long id){
        System.out.println(profileNamespace);
        if(id==0){
            throw new ParameterInvalidException();
        }
        return AjaxResult.success(service.findById(id));
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public AjaxResult list(){
        return AjaxResult.success(service.findAll());
    }

    @ApiOperation(value = "添加图书", notes = "添加图书")
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public AjaxResult add(@RequestBody BookVO vo){
        Book book = new Book();
        BeanUtils.copyProperties(vo,book);
        service.save(book);
        return AjaxResult.success();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public AjaxResult edit(@RequestBody BookVO vo){
        Book book = new Book();
        BeanUtils.copyProperties(vo,book);
        service.save(book);
        return AjaxResult.success();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @OnlyAdmin
    public AjaxResult deleteById(@PathVariable Long id){
        int n = Integer.parseInt("str");
        service.deleteById(id);
        return AjaxResult.success();
    }

}
