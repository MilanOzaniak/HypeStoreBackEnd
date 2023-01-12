package com.example.hypestore.controller;

import com.example.hypestore.model.Item;
import com.example.hypestore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RequestMapping("/item")
@RestController
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/create")
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }

    @PostMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(@RequestParam("image")MultipartFile image) throws IOException{
        itemService.uploadItem(image);
        return "saved";
    }

    @DeleteMapping("/del/{id}")
    public void deleteItem(@PathVariable Integer id){
        itemService.deleteItemById(id);
    }

    //filter
    @GetMapping("/getAll")
    public List<Item> listOfItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/getAllShoes")
    public List<Item> getAllShoes(){
        return itemService.getAllShoes();
    }

    @GetMapping("/getAllClothing")
    public List<Item> getAllClothing(){
        return itemService.getAllClothing();
    }

    @GetMapping("/getAllAccessories")
    public List<Item> getAllAccessories(){
        return itemService.getAllAccessories();
    }
    //
}
