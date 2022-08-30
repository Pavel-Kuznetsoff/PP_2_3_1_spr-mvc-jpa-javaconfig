package com.company.servise.impl;

import com.company.dao.UserDao;
import com.company.model.User;
import com.company.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public User getById(int id) {
        return dao.getById(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        dao.update(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }
}
