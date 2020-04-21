package com.mypersonal.corona.dao;

import com.mypersonal.corona.model.Corona;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.function.Predicate;

public interface CoronaRepository extends JpaRepository<Corona,Integer> {
    public List<Corona> findByCountryName(String countryName);
    public List<Corona> findAllByAffected(int affected);
    public List<Corona> deleteByCountryName(String countryName);
    public List<Corona> findByCountryNameAndAffected(String countryName,int affected);


    @Query("select c from Corona c")
    public List<Corona> getCustomQuerry();
}
