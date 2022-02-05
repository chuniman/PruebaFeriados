/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springboot.service;

import com.example.springboot.dao.feriadoDAO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.example.springboot.model.feriadosModel;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Chuni
 */
@Service
public class service {
    
    @Autowired
    private feriadoDAO ferDAO;
    

  public void restCall(){
    HttpHeaders he = new HttpHeaders();
    he.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    HttpEntity<String> hs = new HttpEntity<>("parameters",he);
      
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://feriados-cl-api.herokuapp.com/feriados";
    
   // ObjectMapper mapper = new ObjectMapper();

    //ResponseEntity<String> re = restTemplate.exchange(url,HttpMethod.GET,hs,String.class);

    List<feriadosModel> listFer = Arrays.asList(restTemplate.getForObject(url, feriadosModel[].class));
    
    for (feriadosModel m : listFer) {
      ferDAO.save(m);
    }
      //System.out.println(re);
      
  }
}
