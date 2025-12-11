package com.spring_rest_api.controller.impl;

import com.spring_rest_api.controller.IHomeController;
import com.spring_rest_api.dto.DtoHome;
import com.spring_rest_api.services.IHomeService;
import com.spring_rest_api.services.impl.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/rest/api/homes")
public class HomeControllerImpl implements IHomeController {
    @Autowired
    private  IHomeService homeService;
    @Override
    @GetMapping ("/{id}")
    public DtoHome findHomeById(@PathVariable(name="id") Long id) {
        return homeService.findHomeById(id);
    }
}
