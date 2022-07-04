package com.flying.book.controller;

import com.flying.book.controller.vo.BookVO;
import com.flying.book.core.exception.ParameterInvalidException;
import com.flying.book.core.web.AjaxResult;
import com.flying.book.domain.Book;
import com.flying.book.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
    public AjaxResult deleteById(@PathVariable Long id){
        int n = Integer.parseInt("str");
        service.deleteById(id);
        return AjaxResult.success();
    }

}
