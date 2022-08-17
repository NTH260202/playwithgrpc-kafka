package com.example.playwithgrpc.service.grpc;

import com.example.playwithgrpc.AccountResponse;
import com.example.playwithgrpc.AccountServiceGrpc;
import com.example.playwithgrpc.GetRequest;
import com.example.playwithgrpc.model.dto.AccountDTO;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

import java.util.ArrayList;
import java.util.List;

@GRpcService
public class AccountServiceImpl extends AccountServiceGrpc.AccountServiceImplBase {
    @Override
    public void getAll(GetRequest request, StreamObserver<AccountResponse> responseStream) {
        List<AccountDTO> accounts = new ArrayList<>();
        accounts.add(new AccountDTO("se160098", "abvyx123", "Nguyen Ha", 20));
        accounts.add(new AccountDTO("se160099", "abv3", "Tran Hai", 15));
        accounts.add(new AccountDTO("se160100","abvysj623",  "Thanh Tuan", 18));
        int maxAge = request.getMaxAge();
        int minAge = request.getMinAge();
        for (AccountDTO account : accounts) {
            if (account.getAge() < maxAge && account.getAge() > minAge) {
                responseStream.onNext(AccountResponse.newBuilder()
                        .setFullName(account.getFullName())
                        .setUsername(account.getUsername())
                        .build());
            }
        }
        responseStream.onCompleted();
    }

    @Override
    public void getById(GetRequest request, StreamObserver<AccountResponse> responseStream) {
        List<AccountDTO> accounts = new ArrayList<>();
        accounts.add(new AccountDTO("se160098", "abvyx123", "Nguyen Ha", 20));
        accounts.add(new AccountDTO("se160099", "abv3", "Tran Hai", 15));
        accounts.add(new AccountDTO("se160100","abvysj623",  "Thanh Tuan", 18));

        for(AccountDTO account: accounts) {
            if (account.getUserId().equals(request.getUserId())) {
                responseStream.onNext(AccountResponse.newBuilder()
                        .setFullName(account.getFullName())
                        .setUsername(account.getUsername())
                                .setDateOfBirth(Timestamp.newBuilder().setSeconds(1660635229).build())
                        .build());
            }
        }
        responseStream.onCompleted();
    }

    @Override
    public StreamObserver<GetRequest> getById1(StreamObserver<AccountResponse> responseStream) {
        List<AccountDTO> accounts = new ArrayList<>();
        accounts.add(new AccountDTO("se160098", "abvyx123", "Nguyen Ha", 20));
        accounts.add(new AccountDTO("se160099", "abv3", "Tran Hai", 15));
        accounts.add(new AccountDTO("se160100","abvysj623",  "Thanh Tuan", 18));
        return new StreamObserver<GetRequest>() {
            String fullName;
            String username;

            @Override
            public void onNext(GetRequest request) {
                for(AccountDTO account: accounts) {
                    if (account.getUserId().equals(request.getUserId())) {
                        fullName = account.getFullName();
                        username = account.getUsername();
                    }
                }
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                responseStream.onNext(AccountResponse.newBuilder()
                        .setFullName(fullName)
                        .setUsername(username)
                        .setDateOfBirth(Timestamp.newBuilder().setSeconds(1660635229).build())
                        .build());
                responseStream.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<GetRequest> getAll1(StreamObserver<AccountResponse> responseStream) {
        List<AccountDTO> accounts = new ArrayList<>();
        accounts.add(new AccountDTO("se160098", "abvyx123", "Nguyen Ha", 20));
        accounts.add(new AccountDTO("se160099", "abv3", "Tran Hai", 15));
        accounts.add(new AccountDTO("se160100","abvysj623",  "Thanh Tuan", 18));
        return new StreamObserver<GetRequest>() {

            @Override
            public void onNext(GetRequest request) {
                for(AccountDTO account: accounts) {
                    if (account.getUserId().equals(request.getUserId())) {
                        responseStream.onNext(AccountResponse.newBuilder()
                                .setFullName(account.getFullName())
                                .setUsername(account.getUsername())
                                .setDateOfBirth(Timestamp.newBuilder().setSeconds(1660635229).build())
                                .build());
                    }
                }
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                responseStream.onCompleted();
            }
        };
    }

}
