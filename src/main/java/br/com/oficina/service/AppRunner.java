/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.service;

import br.com.oficina.service.domain.BiddingEntity;
import br.com.oficina.service.domain.BiddingItemEntity;
import br.com.oficina.service.domain.PublicClientEntity;
import br.com.oficina.service.domain.VehicleEntity;
import br.com.oficina.service.repository.BiddingItemRepository;
import br.com.oficina.service.repository.BiddingRepository;
import br.com.oficina.service.repository.PublicClientRepository;
import br.com.oficina.service.repository.VehicleRepository;
import java.util.Calendar;
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
    
    @Autowired 
    private BiddingRepository bidding;
    
    @Autowired 
    private BiddingItemRepository biddingItem;
    
    @Override
    public void run(String... args) throws Exception {
            client.deleteAll();
            PublicClientEntity p = new PublicClientEntity();
            p.setPublicName("Prefeitura Municipal de Maracaí");
            p.setPublicFantasyName("PM-Maracai");
            p.setAddressDelivery("Av. José Bonifácio, 517, Centro, Maracaí, SP");
            p.setAddressBilling("Av. José Bonifácio, 517, Centro, Maracaí, SP");
            p.setPrimaryContact("Paulo Eduardo da Silva");
            p.setPrimaryEmail("paulo.eduardo@maracai.sp.gov.br");
            p.setPrimaryPhoneNumber("(18) 3371-9500");
            p.setPrimarySupportContact("gabinete@maracai.sp.gov.br");
            p.setObservations("Dados para licitações em Maracaí.");
            p.setStatus(true);
            client.save(p);
            
            vehicle.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                        VehicleEntity v = new VehicleEntity();
                        v.setLicensePlate("ABC-" + (1000 + i));
                        v.setManufactor("Mercedes-Benz");
                        v.setModel("1935");
                        v.setMadeYear("" + (1990 + i));
                        v.setModelYear("" + (1990 + i));
                        v.setObservations("Caminhão com barulho no eixo dianteiro.");
                        v.setStatus(true);
                        v.setClientOwner(client.findById(1L).get());
                        return v;
                    })
                    .map(n -> vehicle.save(n))
                    .forEach(System.out::println);
             
            bidding.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                        BiddingEntity v = new BiddingEntity();
                        int initialMonth = 7;
                        int month = (int) ((initialMonth + i > 11) ? (initialMonth + i) - 12 : (initialMonth + i));
                        int year = (initialMonth + i > 11) ? 2021 : 2020;
                        Calendar init = Calendar.getInstance();
                        Calendar end = Calendar.getInstance();
                        init.set(year, month, (int) (i+2));
                        end.set(year+1, month, (int) (i+2));
                        v.setAlias("alias-" + i);
                        v.setDescription("description " + i);
                        v.setInitialDate(init);
                        v.setExpirateDate(end);
                        v.setObservations("observations " + i);
                        v.setStatus(true);
                        v.setPublicInstitution(client.findById(1L).get());
                        return v;
                    })
                    .map(n -> bidding.save(n))
                    .forEach(System.out::println);

            //bidding.deleteAll();
            bidding.findAll().forEach(e -> { 
            for (int i=1; i<4; i++) {
                BiddingItemEntity b = new BiddingItemEntity();
                b.setItem(i);
                b.setDescription("Description " + i);
                b.setItemCode("101.30" + i);
                b.setBidding( e );
                b.setStatus(true);
                biddingItem.save(b);
            }
            });

    }
}