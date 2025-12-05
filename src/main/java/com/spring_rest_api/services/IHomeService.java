package com.spring_rest_api.services;

import com.spring_rest_api.dto.DtoHome;

public interface IHomeService {
    public DtoHome findHomeById(Long id);
}
