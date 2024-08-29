package com.bottle.rpc.consumer;

import com.bottle.rpc.common.model.User;
import com.bottle.rpc.common.service.UserService;

public class EasyConsumer {
    public static void main(String[] args) {
        UserService userService = null;
        User user = new User();
        user.setName("bottle");
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("执行失败");
        }
    }
}
