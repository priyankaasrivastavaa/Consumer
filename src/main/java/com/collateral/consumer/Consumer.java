package com.collateral.consumer;

import com.collateral.request.AddValuationDTO;
import com.collateral.request.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);


    private final RestTemplate restTemplate;

    @Autowired
    public Consumer(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @KafkaListener(topics = "valuation", groupId = "group_id")
    public void consume(String collateralId) throws Exception {
        AddValuationDTO addValuationDTO = new AddValuationDTO();
        addValuationDTO.setCollateralId(collateralId);
        addValuationDTO.setValuationStatus(Status.COMPLETED);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = "http://localhost:9062/collateral/addvaluation";
        URI uri = new URI(url);
        HttpEntity<AddValuationDTO> requestEntity = new HttpEntity<>(addValuationDTO, headers);
        restTemplate.exchange(uri, HttpMethod.POST, requestEntity, Void.class);
        // restTemplate.postForEntity(uri, addValuationDTO, Void.class);
        logger.info(String.format("#### -> Consumed collateralId -> %s", collateralId));
    }
}
