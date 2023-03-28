package com.srt.example.simplespringbootdockerapp.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public interface QueryProducer {
  QueryProducer createNativeQuery(String query);

  void getSingleResult();
}
