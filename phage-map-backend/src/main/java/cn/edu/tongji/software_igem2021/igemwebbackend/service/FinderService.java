package cn.edu.tongji.software_igem2021.igemwebbackend.service;


import cn.edu.tongji.software_igem2021.igemwebbackend.dto.BacAndPhageInfo;
import cn.edu.tongji.software_igem2021.igemwebbackend.model.ScoreWithNameEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FinderService {
    List<ScoreWithNameEntity> searchForAll(String key);

    List<ScoreWithNameEntity> searchForBacteria(String key);

    List<ScoreWithNameEntity> searchForPhage(String key);

    List<BacAndPhageInfo> querySuggestionForBacteria(String key, int pageNum);

    List<BacAndPhageInfo> querySuggestionForPhage(String key, int pageNum);

    List<BacAndPhageInfo> querySuggestionForAll(String key, int pageNum);
}
