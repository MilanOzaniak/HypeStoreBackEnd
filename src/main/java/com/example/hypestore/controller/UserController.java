package com.example.hypestore.controller;

import com.example.hypestore.model.Item;
import com.example.hypestore.model.User;
import com.example.hypestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "https://milanozaniak.github.io/")
//@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{userName}")
    public Optional<User> getCurrentUser(@PathVariable String userName){
        return userService.getCurrentUser(userName);
    }

    @GetMapping("/del/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "User was deleted";
    }

    @GetMapping("/getItems")
    public List<Item> getItems(){
        return userService.getItemsForCurrentUser();
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("oldPass") String oldPass, @RequestParam("newPass") String newPass){
        return userService.changePassword(oldPass,newPass);
    }

    @PostMapping("/changePnumber")
    public User changePnumber(@RequestParam("pNumber") String pNumber){
        return userService.changePnumber(pNumber);
    }

    @PostMapping("/changeDescription")
    public User changeDescription(@RequestParam("description") String description){
        return userService.changeDescription(description);
    }

    @PostMapping("/addFavItem")
    public String addFavItem(@RequestParam("id") Integer id){
        userService.addFavItem(id);
        return "success";
    }

    @GetMapping("/getFavItem")
    public List<Item> getFavItem(){
        return userService.getFavItem();
    }

    @PostMapping("/removeFavItem")
    public String removeFavItem(@RequestParam("id") Integer id){
        userService.removeFavItem(id);
        return "success";
    }

    @PostMapping("/reserveItem")
    public void reserveItem(@RequestParam("id") int id){
        userService.reserveItem(id);
    }

    @GetMapping("/getReservedItems")
    public List<Item> getReservedItems(){
        return userService.getReservedItems();
    }

    @PostMapping("/removeReservedItem")
    public void removeReservedItem(@RequestParam("id") int id){
        userService.removeReservedItem(id);
    }

    @PostMapping("/setProfileImage")
    public void setProfilePage(@RequestParam("image") MultipartFile image){
        userService.profileImage(image);
    }

    @GetMapping(value = "/getImage/{imageName:.+}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] getFile(@PathVariable String imageName) throws Exception {
        return userService.getProfileImage(imageName);
    }

    @PostMapping("/setInstagram")
    public void setInstagram(@RequestParam("ig") String instagram){
        userService.addInstagram(instagram);
    }

    @PostMapping("/setFacebook")
    public void setFacebook(@RequestParam("fb") String facebook){
        userService.addFacebook(facebook);
    }


}
