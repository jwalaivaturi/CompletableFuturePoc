package com.example.demo;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationUtil {

    private RegistrationUtil(){}

    @SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationUtil.class);
    public static Registration createFakeRegistration(String name){
        LOGGER.info("Calling Creation Registration for {}", name);
        try
        {
            TimeUnit.SECONDS.sleep(3);
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        LOGGER.info("Creating Registration {} from {}" , name , Thread.currentThread().getName() );
        return new Registration(name, UUID.randomUUID().toString());
    }

    public static String tranformRegistration( Registration registation )
	{
		LOGGER.info("Transforming Registration {} from {}" , registation.getName() , Thread.currentThread().getName() );
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            return mapper.writeValueAsString(registation);
        }
        catch ( JsonProcessingException e )
        {
            e.printStackTrace();
        }
        return null;
	}

    public static void invokeCallbackUrl( String registrationJson )
	{
		LOGGER.info("Callback URL invoked for {}", registrationJson);
	}
    
}
