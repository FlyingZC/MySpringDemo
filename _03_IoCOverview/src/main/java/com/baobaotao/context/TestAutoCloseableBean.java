package com.baobaotao.context;

import org.springframework.stereotype.Component;

@Component
public class TestAutoCloseableBean implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("AutoCloseable.close()..");
    }
}
