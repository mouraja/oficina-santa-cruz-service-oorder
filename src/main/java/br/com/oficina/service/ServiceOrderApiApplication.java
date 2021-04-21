package br.com.oficina.service;

import br.com.oficina.service.domain.PublicClientEntity;
import br.com.oficina.service.domain.VehicleEntity;
import br.com.oficina.service.repository.PublicClientRepository;
import br.com.oficina.service.repository.VehicleRepository;
import java.util.stream.LongStream;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ServiceOrderApiApplication {

  /*
    @Bean
    CommandLineRunner init(PublicClientRepository repository) {
        return args -> {
            repository.deleteAll();
            Boolean status=true;
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                        PublicClientEntity c = new PublicClientEntity();
                        c.setPublicName("publicName " + i);
                        c.setPublicFantasyName("publicFantasyName " + i);
                        c.setAddressDelivery("Rua addressDelivery" + i);
                        c.setAddressBilling("Rua addressBilling" + i);
                        c.setPrimaryContact("primaryContact " + i);
                        c.setPrimaryEmail("primaryEmail" + i + "@prefeitura.gov.br");
                        c.setPrimaryPhoneNumber("(18) " + i + "-1111");
                        c.setPrimarySupportContact("0800-" + i + "-1111");
                        c.setObservations("observations " + i);
                        c.setStatus(i % 2 == 0);
                        return c;
                    })
                    .map(v -> repository.save(v))
                    .forEach(System.out::println);
        };
        
    }
    */
  
    /**
     *
     * @return
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
    @Configuration
    @EnableWebMvc
    public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
	}
    }
        
    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApiApplication.class, args);
    }

}
