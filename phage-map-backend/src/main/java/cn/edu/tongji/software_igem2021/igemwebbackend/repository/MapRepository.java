package cn.edu.tongji.software_igem2021.igemwebbackend.repository;

import cn.edu.tongji.software_igem2021.igemwebbackend.model.BugScoreWithNameEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.model.BugScoreWithNameEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository
        extends JpaRepository<BugScoreWithNameEntity, BugScoreWithNameEntityPK> {

}
