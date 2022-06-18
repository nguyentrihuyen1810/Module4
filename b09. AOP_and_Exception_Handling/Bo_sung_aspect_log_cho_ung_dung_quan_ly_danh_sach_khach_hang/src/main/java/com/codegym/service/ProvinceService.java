package com.codegym.service;

import com.codegym.model.Province;
import java.util.List;

public class ProvinceService {
    List<Province> findAll();

    Province findOne(Long id);

    Province save(Province Province);

    List<Province> save(List<Province> Provinces);

    boolean exists(Long id);

    List<Province> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Province Province);

    void delete(List<Province> Provinces);

    void deleteAll();
}
