package com.llazar.user_service;

import com.llazar.user_service.Service.DummyService;
import com.llazar.user_service.model.Dummy;
import com.llazar.user_service.repository.DummyRepo;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;



public class DummyTest {

    private DummyRepo dummyRepo;
    private DummyService dummyService;

    @BeforeEach
    void init()
    {
        dummyService = new DummyService(dummyRepo);
    }

    @Test
    void test()
    {
        Dummy dummy = new Dummy("user1","emai@emal.com");

        Assert.assertEquals(dummy.getEmail(),"emai@emal.com");
    }
}
