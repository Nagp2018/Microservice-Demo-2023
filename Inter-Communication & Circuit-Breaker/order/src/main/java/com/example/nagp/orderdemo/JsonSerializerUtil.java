package com.example.nagp.orderdemo;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonSerializerUtil {

  private static final Logger log = LoggerFactory.getLogger(JsonSerializerUtil.class);
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static String serialize(Object object) {
    String retVal = null;
    try {
      retVal = objectMapper.writeValueAsString(object);
    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return retVal;
  }


}
