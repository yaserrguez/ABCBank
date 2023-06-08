/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 9:18 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.configuration;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateConfiguration
{

	 private static final String dateFormat = "dd/MM/yyyy";
	 
	 private static final String dateTimeFormat = "dd/MM/yyyy HH:mm:ss";
	 
	 @Bean
	 public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer()
	 {
		 
	    return builder -> {
	    	
	        builder.simpleDateFormat(dateTimeFormat);
	        
	        builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
	        
	        builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
	        
	    };
	    
	 }
	    
}

