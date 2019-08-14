package com.repository;

import com.model.Code;
import com.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {

    Optional<Code> findFirstByUserOrderByIdDesc(User user);
}
