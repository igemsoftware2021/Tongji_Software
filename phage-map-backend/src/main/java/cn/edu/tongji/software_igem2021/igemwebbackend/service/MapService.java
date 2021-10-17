package cn.edu.tongji.software_igem2021.igemwebbackend.service;

import cn.edu.tongji.software_igem2021.igemwebbackend.model.BugScoreWithNameEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.model.SuperBugEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.repository.MapRepository;
import cn.edu.tongji.software_igem2021.igemwebbackend.repository.SuperBugRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Stream;

@Service
public class MapService {

    @Resource
    MapRepository mapRepository;

    @Resource
    SuperBugRepository superBugRepository;

    public List<BugScoreWithNameEntity> getAll() {
        return mapRepository.findAll();
    }

    public List<SuperBugEntity> getAllSuperBugs() {
        List<SuperBugEntity> temp = superBugRepository.findAll();
        Set<Integer> taxon_ids = new HashSet<>();
        List<SuperBugEntity> newList = new ArrayList<>();

        for (SuperBugEntity sbe: temp) {
            if (taxon_ids.contains(sbe.getTxid())) {
                Stream<SuperBugEntity> alreadyAdded = newList.stream().filter((superBugEntity -> superBugEntity.getTxid().equals(sbe.getTxid())));
                Optional<SuperBugEntity> s = alreadyAdded.findFirst();
                s.ifPresent(superBugEntity -> superBugEntity.setBugSeqId(
                        superBugEntity.getBugSeqId() + " / " + sbe.getBugSeqId()
                ));
            } else {
                newList.add(sbe);
                taxon_ids.add(sbe.getTxid());
            }
        }
        return newList;
    }
}
