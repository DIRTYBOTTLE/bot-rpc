package com.bottle.rpc.provider;

import com.bottle.rpc.common.model.User;
import com.bottle.rpc.common.service.UserService;

public class UserServiceImpl implements UserService {
    public User getUser(User user) {
        user.setName(user.getName() + ".Fake");
        return user;
    }
}
