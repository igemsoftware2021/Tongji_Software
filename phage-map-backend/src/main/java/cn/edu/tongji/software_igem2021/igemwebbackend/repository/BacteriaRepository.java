package cn.edu.tongji.software_igem2021.igemwebbackend.repository;

import cn.edu.tongji.software_igem2021.igemwebbackend.model.ValidBacteriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BacteriaRepository
        extends JpaRepository<ValidBacteriaEntity, String>,
        JpaSpecificationExecutor<ValidBacteriaEntity> {
}
