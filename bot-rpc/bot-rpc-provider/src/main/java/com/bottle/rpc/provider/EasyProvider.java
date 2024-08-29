package com.bottle.rpc.provider;

import com.bottle.rpc.common.service.UserService;
import com.bottle.rpc.registry.LocalRegistry;
import com.bottle.rpc.server.HttpServer;
import com.bottle.rpc.server.VertxHttpServer;

public class EasyProvider {
    public static void main(String[] args) {
        LocalRegistry.registry(UserService.class.getName(), UserServiceImpl.class);

        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
