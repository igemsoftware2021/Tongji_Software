package cn.edu.tongji.software_igem2021.igemwebbackend.controller;

import cn.edu.tongji.software_igem2021.igemwebbackend.model.BugScoreWithNameEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.model.SuperBugEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.service.MapService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/map")
public class MAP {
    @Resource
    MapService mapService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<BugScoreWithNameEntity> getAllForMAP() {
        return mapService.getAll();
    }

    @RequestMapping(value = "/bug/all", method = RequestMethod.GET)
    public List<SuperBugEntity> getAllSuperBugs() {
        return mapService.getAllSuperBugs();
    }
}
