package com.chaocharliehuang.countriesjpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chaocharliehuang.countriesjpa.models.*;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

}
