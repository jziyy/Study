package com.example.demo.test;

import java.util.concurrent.atomic.AtomicLong;

public class TestInteger {

        private final AtomicLong counter = new AtomicLong();
        public void increase() {
            counter.incrementAndGet();
        }



}
