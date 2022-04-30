package com.zhivotin.serviceshuffle.service;

import com.zhivotin.serviceshuffle.model.LogObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LogService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${application.name}")
    private String applicationName;
    @Value("${log-server.url}")
    private String logserverUrl;

    @Async
    public void sendLog(Integer number) {
        HttpEntity<LogObject<Integer>> request = new HttpEntity<>(new LogObject<>(applicationName, number));
        restTemplate.exchange(logserverUrl, HttpMethod.POST, request, Void.class);
    }
}
