package org.lee.feign;

import org.lee.entity.Menu;
import org.lee.entity.MenuVO;
import org.lee.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {

    /*获取全部菜品*/
    @GetMapping("/menu/findAll/{index}/{limit}")
    MenuVO findAll(@PathVariable("index")int index, @PathVariable("limit")int limit);

    /*删除菜品*/
    @DeleteMapping("/menu/deleteById/{id}")
    void deleteById(@PathVariable("id")long id);

    /*返回添加菜品时菜的分类集合*/
    @GetMapping("/menu/findAllTypes")
    List<Type> findAllTypes();

    /*添加菜品*/
    @PostMapping("/menu/save")
    void save(Menu menu);

    @GetMapping("/menu/findById/{id}")
    Menu findById(@PathVariable("id") long id);

    @PutMapping("/menu/update")
    void update(Menu menu);

}
