package com.riwi.RiwiMarket.infrastructure.helpers;

import com.riwi.RiwiMarket.domain.entities.Store;
import com.riwi.RiwiMarket.domain.repositories.StoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
public class DatabaseStoreSeeder implements CommandLineRunner {

    private final StoreRepository storeRepository;

    public DatabaseStoreSeeder(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        // insert a static store by a seeder component

        Store store = new Store();

        store.setId(Long.valueOf("1"));
        store.setName("RiwiMarket");
        store.setAddress("calle 10#39-16");
        store.setEmail("Riwi@gamil.com");
        store.setPhone("32257839");
        store.setNit("129182903");
        store.setAvailable(BigDecimal.valueOf(0));
        store.setEmployees(new ArrayList<>());

        storeRepository.save(store);

        System.out.println("Store created succesfully by the seeder component");
    }


}
