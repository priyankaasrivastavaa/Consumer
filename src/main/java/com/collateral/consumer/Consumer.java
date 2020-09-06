package com.collateral.consumer;

import com.collateral.service.impl.CollateralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private CollateralService service;

    @KafkaListener(topics = "valuation", groupId = "group_id")
    public void consume(String message) throws Exception {
        service.addValuation(message);
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
