package cn.edu.tongji.software_igem2021.igemwebbackend.dto.mappers;

import cn.edu.tongji.software_igem2021.igemwebbackend.dto.BacAndPhageInfo;
import cn.edu.tongji.software_igem2021.igemwebbackend.model.ValidBacteriaEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.model.ValidPhageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface MapStructMapper {

    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

    List<BacAndPhageInfo> allToBacAndPhageInfo(List<ValidBacteriaEntity> bacterias);

    List<BacAndPhageInfo> allToBacAndPhageInfo(Collection<ValidPhageEntity> phages);
}
