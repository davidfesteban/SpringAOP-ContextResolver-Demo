package com.example.demo.service;

import com.example.demo.annotation.Interceptor;
import com.example.demo.entity.DemoEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.demo.repository.DemoRepository;

@Service
@AllArgsConstructor
@Slf4j
public class DemoService {

    private DemoRepository demoRepository;

    @Interceptor
    public void perform() {
        log.info("Starting DemoService");
        demoRepository.foo(new DemoEntity());
        log.info("Ending DemoService");
    }

}
