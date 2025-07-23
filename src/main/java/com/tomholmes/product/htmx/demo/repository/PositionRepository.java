package com.tomholmes.product.htmx.demo.repository;

import com.tomholmes.product.htmx.demo.model.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("positionRepository")
public interface PositionRepository extends JpaRepository<PositionEntity, Long>
{

}
