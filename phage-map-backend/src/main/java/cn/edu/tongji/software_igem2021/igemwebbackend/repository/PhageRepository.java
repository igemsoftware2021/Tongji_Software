package cn.edu.tongji.software_igem2021.igemwebbackend.repository;

import cn.edu.tongji.software_igem2021.igemwebbackend.model.ValidPhageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PhageRepository
        extends JpaRepository<ValidPhageEntity, String>,
        JpaSpecificationExecutor<ValidPhageEntity> {
}
