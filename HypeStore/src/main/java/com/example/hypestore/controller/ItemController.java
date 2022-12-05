package com.example.hypestore.controller;

import com.example.hypestore.model.Item;
import com.example.hypestore.model.User;
import com.example.hypestore.repository.ItemRepository;
import com.example.hypestore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Access;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Locale;

@RequestMapping("/item")
@RestController
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;


    public static String uploadDirectory = System.getProperty("user.dir") + "/files/images";

    @PostMapping("/create")
    @ResponseBody
    public Item createItem(@ModelAttribute Item item, @RequestParam("image")MultipartFile image) throws IOException {

        StringBuilder fileNames = new StringBuilder();
        String fileName = image.getOriginalFilename();
        Path fileNameAndPath = Paths.get(uploadDirectory,fileName);
        try {
            Files.write(fileNameAndPath, image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemService.createItem(item, image);
    }

    @GetMapping("/getAll")
    public List<Item> listOfItems(){
        return itemService.getAllItems();
    }

    @DeleteMapping("/del/{id}")
    public void deleteItem(@PathVariable Integer id){
        itemService.deleteItemById(id);
    }

}
