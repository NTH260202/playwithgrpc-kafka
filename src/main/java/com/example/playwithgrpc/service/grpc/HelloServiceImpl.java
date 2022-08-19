package com.example.playwithgrpc.service.grpc;

import com.example.playwithgrpc.HelloRequest;
import com.example.playwithgrpc.HelloResponse;
import com.example.playwithgrpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.cache.annotation.Cacheable;

@GRpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responses) {
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstname())
                .append(" ")
                .append(request.getLastname())
                .toString();
        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();
        responses.onNext(response);
        responses.onCompleted();
    }
}
