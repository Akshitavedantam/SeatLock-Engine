package com.seatlock.engine;

import org.springframework.web.client.RestTemplate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyTest {
    public static void main(String[] args) throws InterruptedException {
        int numberOfUsers = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(100);
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("starting the crash..");
        for (int i = 0; i < numberOfUsers; i++) {
            executor.submit(() -> {
                try {

                    String payload = "{\"eventId\": 7, \"userEmail\": \"bot@test.com\", \"seats\": 1}";
                    restTemplate.postForObject("http://localhost:9090/bookings", parseJson(payload), String.class);
                } catch (Exception e) {

                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Crash finished. CHECK THE DATABASE!");
    }
    private static java.util.Map<String, Object> parseJson(String json) {
        java.util.Map<String, Object> map = new java.util.HashMap<>();
        map.put("eventId",7);
        map.put("userEmail", "bot@test.com");
        map.put("seats", 1);
        return map;
    }
}