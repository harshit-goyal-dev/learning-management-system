package com.harshit.learningmanagementsystem.services;

import com.harshit.learningmanagementsystem.exceptions.InvalidNumberFormatException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EasterEggService
{
    public String getRandomFact(int number){
        if(!(Integer.MIN_VALUE<number && number<Integer.MAX_VALUE))
            throw new InvalidNumberFormatException("Please provide a integer value");
        String uri = "http://numbersapi.com/"+number;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(uri,String.class);
        return response;
    }

}
