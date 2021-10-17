package cn.edu.tongji.software_igem2021.igemwebbackend.repository;

import cn.edu.tongji.software_igem2021.igemwebbackend.model.ScoreWithNameEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.model.ScoreWithNameEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface FinderRepository
        extends JpaRepository<ScoreWithNameEntity, ScoreWithNameEntityPK>,
        JpaSpecificationExecutor<ScoreWithNameEntity> {

}
