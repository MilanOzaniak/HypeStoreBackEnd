package com.example.hypestore.service;

import com.example.hypestore.model.Item;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ItemService {
    Item createItem(Item item, MultipartFile file) throws IOException;
    List<Item> getAllItems();
    void deleteItemById(int id);
}
