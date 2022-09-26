package com.example.playwithgrpc.service.grpc;

import com.example.playwithgrpc.model.entity.Clinic;
import com.example.playwithgrpc.repository.ClinicRepository;
import com.unicloud.bizzone.demo.service.ClinicDetailResponse;
import com.unicloud.bizzone.demo.service.ClinicServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.lognet.springboot.grpc.GRpcService;

import java.util.UUID;

@GRpcService
@RequiredArgsConstructor
public class ClinicServiceImpl extends ClinicServiceGrpc.ClinicServiceImplBase {
    private final ClinicRepository clinicRepository;
    @Override
    public void getById(com.unicloud.bizzone.demo.service.ClinicIdRequest request,
                        StreamObserver<ClinicDetailResponse> responseObserver) {
        Clinic clinic = clinicRepository.getClinicById(UUID.fromString(request.getId()));
        responseObserver.onNext(ClinicDetailResponse.newBuilder().setId(clinic.getId().toString())
                        .setPhone(clinic.getPhone())
                .build());
        responseObserver.onCompleted();
    }
}
