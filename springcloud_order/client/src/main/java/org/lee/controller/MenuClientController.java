package org.lee.controller;

import org.lee.entity.Menu;
import org.lee.entity.MenuVO;
import org.lee.entity.Type;
import org.lee.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientM")
public class MenuClientController {

    @Autowired
    private MenuFeign menuFeign;

    /*测试接口方法*/
    @GetMapping("/findAll/{index}/{limit}")
    @ResponseBody
    public MenuVO findAll(@PathVariable("index")int index, @PathVariable("limit")int limit){
        return menuFeign.findAll(index,limit);
    }

    /*菜品数据*/
    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAllC(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        return menuFeign.findAll(index,limit);
    }

    /*菜品展示页*/
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    /*删除菜品*/
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")long id){
        menuFeign.deleteById(id);
        return "redirect:/clientM/index";
    }

    @GetMapping("/findAllTypes")
    public String findAllTypes(Model model){
        List<Type> allTypes = menuFeign.findAllTypes();
        model.addAttribute("typesList",allTypes);
        return "menu_add";
    }

    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "redirect:/clientM/index";
    }
}
