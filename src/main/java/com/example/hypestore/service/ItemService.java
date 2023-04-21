package com.example.hypestore.service;

import com.example.hypestore.model.Item;
import com.example.hypestore.model.ItemBasicInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item createItem(Item item);
    void uploadImage(MultipartFile file) throws IOException;
    ResponseEntity<String> uploadFiles(MultipartFile[] files);
    byte[] getFile(String filename) throws Exception;
    byte[] getAllFiles(int id) throws Exception;
    void deleteItemById(int id) throws Exception;
    Optional<Item> getCurrentItem(int id);
    Item changeCurrentitem(ItemBasicInfo itemBasicInfo);

    //filter
    List<Item> getAllItems();
    List<Item> getAllShoes();
    List<Item> getAllClothing();
    List<Item> getAllAccessories();
    List<Item> getByPriceDesc();
    List<Item> getByPriceAsc();
    List<Item> getBySize(String size);
}
