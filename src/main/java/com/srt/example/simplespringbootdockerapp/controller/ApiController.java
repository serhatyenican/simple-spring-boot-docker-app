package com.srt.example.simplespringbootdockerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController
{
  @Autowired
  QueryProducer queryProducer;

  @GetMapping(value = "/authenticate")
  @ResponseBody
  public ResponseEntity<String> authenticate(
    @RequestParam("user") String user,
    @RequestParam("pass") String pass)
  {
    String query = "SELECT * FROM users WHERE user = '" + user + "' AND pass = '" + pass + "'";
    try {
      queryProducer
        .createNativeQuery(query)
        .getSingleResult();

    } catch (Exception e) {
      return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
    }

    return new ResponseEntity<>("Authentication Success", HttpStatus.OK);
  }
}
