package org.lee.feign;

import org.lee.entity.Menu;
import org.lee.entity.MenuVO;
import org.lee.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {

    /*获取全部菜品*/
    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index")int index, @PathVariable("limit")int limit);

    /*删除菜品*/
    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id")long id);

    /*返回添加菜品时菜的分类集合*/
    @GetMapping("/menu/findAllTypes")
    public List<Type> findAllTypes();

    /*添加菜品*/
    @PostMapping("/menu/save")
    public void save(Menu menu);

}
