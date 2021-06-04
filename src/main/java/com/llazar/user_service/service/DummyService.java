package com.llazar.user_service.service;

import com.llazar.user_service.model.Dummy;
import com.llazar.user_service.repository.DummyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DummyService {

    private final DummyRepo dummyRepo;

    public Dummy createDummy(Dummy dummy){
       return (Dummy) this.dummyRepo.save(dummy);
    }
}
