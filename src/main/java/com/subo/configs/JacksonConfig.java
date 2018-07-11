package com.subo.configs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfig {

	/**
	 * jackson objectMapper注入及配�?
	 * @return ObjectMapper
	 */
	@Bean
	@ConditionalOnMissingBean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		//不序列化null�?""
		mapper.setSerializationInclusion(Include.NON_NULL);
        return mapper;
	}
	
}
