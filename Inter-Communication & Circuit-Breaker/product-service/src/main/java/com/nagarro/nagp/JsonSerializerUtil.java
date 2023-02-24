package com.nagarro.nagp;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nagarro.nagp.model.Order;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonSerializerUtil {

  private static final Logger log = LoggerFactory.getLogger(JsonSerializerUtil.class);
  private static final ObjectMapper objectMapper = new ObjectMapper();
  
  private static final ObjectMapper mapper  = new ObjectMapper()
	        .findAndRegisterModules()
	        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

  public static String serialize(Object object) {
    String retVal = null;
    try {
      retVal = objectMapper.writeValueAsString(object);
    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return retVal;
  }

  public static Order orderPayload(String respData) {
    Order order = null;
    try {
    	
    	order = mapper.readValue(respData, Order.class);
     
   /*   order = objectMapper
          .readValue(respData, new TypeReference<Order>() {
          });*/

    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return order;
  }


}
