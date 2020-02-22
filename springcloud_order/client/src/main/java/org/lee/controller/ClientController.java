package org.lee.controller;

import org.lee.entity.Menu;
import org.lee.entity.MenuVO;
import org.lee.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private MenuFeign menuFeign;

    /*测试接口方法*/
    @GetMapping("/findAll/{index}/{limit}")
    @ResponseBody
    public MenuVO findAll(@PathVariable("index")int index, @PathVariable("limit")int limit){
        return menuFeign.findAll(index,limit);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAllC(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return menuFeign.findAll(index,limit);
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
