package com.spring_rest_api.controller;

import com.spring_rest_api.dto.DtoHome;

import java.util.List;

public interface IHomeController {
    public DtoHome findHomeById(Long id);
}
