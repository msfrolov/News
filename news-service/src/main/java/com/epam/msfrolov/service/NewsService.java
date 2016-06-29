package com.epam.msfrolov.service;

import com.epam.msfrolov.dto.DTO;

import java.util.List;

public interface NewsService {

    List<DTO> getAll();

    DTO findById(int id);

    DTO save(DTO dto);

    DTO update(DTO dto);

    void remove(Integer [] idArray);

    void remove(int id);

    void remove(DTO dto);
}
