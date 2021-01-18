package com.iyad.exchangerate.repositories;

import com.iyad.exchangerate.dto.RateDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<RateDTO, Long> {

}
