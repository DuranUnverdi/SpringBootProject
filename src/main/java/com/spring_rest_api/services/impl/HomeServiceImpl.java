package com.spring_rest_api.services.impl;

import com.spring_rest_api.dto.DtoHome;
import com.spring_rest_api.dto.DtoRoom;
import com.spring_rest_api.entities.Home;
import com.spring_rest_api.entities.Room;
import com.spring_rest_api.repository.HomeRepository;
import com.spring_rest_api.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public DtoHome findHomeById(Long id) {
        Optional<Home> optional = homeRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        Home home = optional.get();

        // Ana DTO
        DtoHome dtoHome = new DtoHome();
        BeanUtils.copyProperties(home, dtoHome);

        // Oda listesi varsa dönüştür
        if (home.getRoom() != null) {
            for (Room r : home.getRoom()) {
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(r, dtoRoom);
                dtoHome.getRoom().add(dtoRoom);
            }
        }

        return dtoHome;
    }
}

