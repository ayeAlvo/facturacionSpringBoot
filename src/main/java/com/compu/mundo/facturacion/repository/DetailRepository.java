package com.compu.mundo.facturacion.repository;

import com.compu.mundo.facturacion.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Detail, Long> {
}
