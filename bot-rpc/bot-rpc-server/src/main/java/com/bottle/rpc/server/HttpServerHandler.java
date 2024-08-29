package com.bottle.rpc.server;

import com.bottle.rpc.model.RpcRequest;
import com.bottle.rpc.model.RpcResponse;
import com.bottle.rpc.serializer.JdkSerializer;
import com.bottle.rpc.serializer.Serializer;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;


public class HttpServerHandler implements Handler<HttpServerRequest> {

    @Override
    public void handle(HttpServerRequest request) {
        final Serializer serializer = new JdkSerializer();
        System.out.println("Receive request: " + request.method() + " " + request.uri());
        request.bodyHandler(body -> {
            byte[] bytes = body.getBytes();
            RpcRequest rpcRequest = null;
            try {
                rpcRequest = serializer.deserialize(bytes, RpcRequest.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            RpcResponse rpcResponse = new RpcResponse();
            if (rpcRequest == null) {
                rpcResponse.setMessage("rpcRequest is null");
//                doRes TODO
            }
        });
    }
}
