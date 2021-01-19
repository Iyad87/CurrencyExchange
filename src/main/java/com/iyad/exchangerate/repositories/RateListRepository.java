package com.iyad.exchangerate.repositories;

import com.iyad.exchangerate.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateListRepository  extends JpaRepository <Rate , Long> {

}
