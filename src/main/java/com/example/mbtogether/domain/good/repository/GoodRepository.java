package com.example.mbtogether.domain.good.repository;

import com.example.mbtogether.domain.good.entity.Good;
import com.example.mbtogether.domain.good.entity.GoodId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<Good, GoodId> {
}
