package com.voluntra.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.RateDto;
import com.voluntra.backend.entity.RateEntity;

@Service
public interface RateService {
    List<RateEntity> getAllRates();
    RateEntity addRate(RateDto rateDto);
    List<RateEntity> getRatesByUsers(Long id);
    List<RateEntity> getRatesByOppos(Long id);
    List<RateEntity> getRatesByOrg(Long id);
}
