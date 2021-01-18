package com.iyad.exchangerate.repositories;

import com.iyad.exchangerate.dto.RateDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<RateDTO, Long> {

}
