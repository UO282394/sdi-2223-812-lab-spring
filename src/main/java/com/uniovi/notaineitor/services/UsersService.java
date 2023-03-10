package com.uniovi.notaineitor.services;
import java.util.*;
import javax.annotation.PostConstruct;

import com.uniovi.notaineitor.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.notaineitor.entities.*;
import com.uniovi.notaineitor.services.UsersService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostConstruct
    public void init() {
    }
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }
    public User getUser(Long id) {
        return usersRepository.findById(id).get();
    }
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }
    public void updateUser(User user,Long id) {
       String dni = user.getDni();
       String name = user.getName();
       String surName = user.getLastName();
       User u =getUser(id);
       u.setDni(dni);
       u.setName(name);
       u.setLastName(surName);
       usersRepository.save(u);

    }
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
    public User getUserByDni(String dni) {
        return usersRepository.findByDni(dni);
    }
}