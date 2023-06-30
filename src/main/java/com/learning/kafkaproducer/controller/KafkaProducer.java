package com.learning.kafkaproducer.controller;

import com.learning.kafkaproducer.bean.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired KafkaTemplate<String, Claim> kafkaTemplate;

    private static final String TOPIC = "Claims";

    @PostMapping("/kafka/publish")
    public String publishClaims(@RequestBody Claim claim) {

        logger.info(String.format("$$$$ => Produced message: %s", claim.getClaimId() + ":" + claim.getClaimType()));

        // Sending the message
        kafkaTemplate.send(TOPIC, claim);
        return "Published Successfully";
    }
}
