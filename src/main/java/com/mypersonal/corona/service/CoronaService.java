package com.mypersonal.corona.service;

import com.mypersonal.corona.dao.CoronaRepository;
import com.mypersonal.corona.model.Corona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

@Service
public class CoronaService {
    @Autowired
    private CoronaRepository cornaDao;



    @PostConstruct
    public void initDB()
    {
        List<Corona> corona=new CopyOnWriteArrayList<>();
        corona.add(new Corona("India",10654,225,233));
        corona.add(new Corona("Austrailia",12554,152,254));
        corona.add(new Corona("Pakistan",1024,285,23));
        corona.add(new Corona("India",10654,24525,2233));
        corona.add(new Corona("England",10254,2225,213));
        corona.add(new Corona("WestIndies",22254,2245,233));
        corona.add(new Corona("Zimbamwe",10546,251,222));
        cornaDao.saveAll(corona);
    }

    public List<Corona> getAll()
    {
        return cornaDao.findAll();
    }

    public List<Corona> getAffectedWithCountry(String countryName)
    {
        return cornaDao.findByCountryName(countryName);
    }
    public List<Corona> getAffectedWithCondition( int affected )
    {
        return cornaDao.findAllByAffected(affected);
    }
    public String getNoOfCountryAffected()
    {
        return "No of Country Affected Till Now In The World Are: "+cornaDao.count();
    }
    public List<Corona> DeleteCornaAffectedCountryByName(String countryName)
    {
       return cornaDao.deleteByCountryName(countryName);
    }
    public List<Corona> showDetailsOfCountryWithSameNameAndAffectedRate(String countryName,int affected)
    {
        return cornaDao.findByCountryNameAndAffected(countryName,affected);
    }
    public List<Corona> getSort(String field)
    {
        return cornaDao.findAll(Sort.by(field));
    }
    public List<Corona> getCustomizationQuerry()
    {
        return cornaDao.getCustomQuerry();
    }
}
