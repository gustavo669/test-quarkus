package com.beesion.ms.test.repository;

import com.beesion.ms.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Repositorio para operaciones con base de datos. Se mantiene limpio de lógica de negocio.
 */
@ApplicationScoped
public class PersonRepo implements PanacheRepository<Person> {
}

