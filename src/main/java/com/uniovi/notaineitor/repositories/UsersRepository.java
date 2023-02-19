package com.uniovi.notaineitor.repositories;
import com.uniovi.notaineitor.entities.*;
import org.springframework.data.repository.CrudRepository;
public interface UsersRepository extends CrudRepository<User, Long>{
    User findByDni(String dni);
}