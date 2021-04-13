package br.com.oficina.service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceOrderApiApplication {
    
    /**
     *
     * @return
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
        
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApiApplication.class, args);
    }

}
