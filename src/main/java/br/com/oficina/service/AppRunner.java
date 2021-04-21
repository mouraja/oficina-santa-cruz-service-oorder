/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service;

import br.com.oficina.service.domain.PublicClientEntity;
import br.com.oficina.service.domain.VehicleEntity;
import br.com.oficina.service.repository.PublicClientRepository;
import br.com.oficina.service.repository.VehicleRepository;
import java.util.stream.LongStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    //private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private PublicClientRepository client;
    
    @Autowired 
    private VehicleRepository vehicle;

    @Override
    public void run(String... args) throws Exception {
            client.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                        PublicClientEntity p = new PublicClientEntity();
                        p.setPublicName("publicName " + i);
                        p.setPublicFantasyName("publicFantasyName " + i);
                        p.setAddressDelivery("Rua addressDelivery" + i);
                        p.setAddressBilling("Rua addressBilling" + i);
                        p.setPrimaryContact("primaryContact " + i);
                        p.setPrimaryEmail("primaryEmail" + i + "@prefeitura.gov.br");
                        p.setPrimaryPhoneNumber("(18) " + i + "-1111");
                        p.setPrimarySupportContact("0800-" + i + "-1111");
                        p.setObservations("observations " + i);
                        p.setStatus(i % 2 == 0);
                        return p;
                    })
                    .map(n -> client.save(n))
                    .forEach(System.out::println);
            
            vehicle.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                        VehicleEntity v = new VehicleEntity();
                        v.setLicensePlate("ABC-" + (1000 + i));
                        v.setManufactor("manufactor " + i);
                        v.setModel("Model " + i);
                        v.setMadeYear("" + (1990 + i));
                        v.setModelYear("" + (1990 + i));
                        v.setObservations("observations " + i);
                        v.setStatus(i % 2 == 0);
                        v.setClientOwner(client.findById(i).get());
                        return v;
                    })
                    .map(n -> vehicle.save(n))
                    .forEach(System.out::println);
    }
}