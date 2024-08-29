package com.bottle.rpc.server;

import io.vertx.core.Vertx;

public class VertxHttpServer implements HttpServer{
    public void doStart(Integer port) {
        Vertx vertx = Vertx.vertx();
        io.vertx.core.http.HttpServer server = vertx.createHttpServer();
        server.requestHandler(request -> {
            System.out.println("Receive request: " + request.method() + " " + request.uri());
            request.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x HTTP server!");
        });

        server.listen(port, result -> {
            if (result.succeeded()) {
                System.out.println("Server is listening on port" + port);
            } else {
                System.err.println("Failed to start server" + result.cause());
            }
        });
    }
}
