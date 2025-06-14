package com.beesion.ms.test.repository;

import com.beesion.ms.model.Address;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.list;

@ApplicationScoped
public class AddressRepository implements PanacheRepository<Address> {

    public List<Address> findByPersonId(Long personId) {
        return list("person.id", personId);
    }
}
