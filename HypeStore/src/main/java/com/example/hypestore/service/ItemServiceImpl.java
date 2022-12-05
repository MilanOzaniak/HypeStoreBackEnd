package com.example.hypestore.service;

import com.example.hypestore.model.Item;
import com.example.hypestore.model.User;
import com.example.hypestore.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserService userService;

    @Override
    public Item createItem(Item item, MultipartFile file) throws IOException {
        item.setImage(file);
        item.setUser(userService.getCurrentUser());
        item.setUserName(userService.getCurrentUser().getUserName());
        item.setDate(LocalDate.now());
        item.setImageName(file.getOriginalFilename());

        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteItemById(int id) {
        itemRepository.deleteById(id);
    }
}
