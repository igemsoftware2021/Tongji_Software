package cn.edu.tongji.software_igem2021.igemwebbackend.dto.mappers;

import cn.edu.tongji.software_igem2021.igemwebbackend.dto.BacAndPhageInfo;
import cn.edu.tongji.software_igem2021.igemwebbackend.model.ValidBacteriaEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.model.ValidPhageEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-15T09:57:40+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Amazon.com Inc.)"
)
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public List<BacAndPhageInfo> allToBacAndPhageInfo(List<ValidBacteriaEntity> bacterias) {
        if ( bacterias == null ) {
            return null;
        }

        List<BacAndPhageInfo> list = new ArrayList<BacAndPhageInfo>( bacterias.size() );
        for ( ValidBacteriaEntity validBacteriaEntity : bacterias ) {
            list.add( validBacteriaEntityToBacAndPhageInfo( validBacteriaEntity ) );
        }

        return list;
    }

    @Override
    public List<BacAndPhageInfo> allToBacAndPhageInfo(Collection<ValidPhageEntity> phages) {
        if ( phages == null ) {
            return null;
        }

        List<BacAndPhageInfo> list = new ArrayList<BacAndPhageInfo>( phages.size() );
        for ( ValidPhageEntity validPhageEntity : phages ) {
            list.add( validPhageEntityToBacAndPhageInfo( validPhageEntity ) );
        }

        return list;
    }

    protected BacAndPhageInfo validBacteriaEntityToBacAndPhageInfo(ValidBacteriaEntity validBacteriaEntity) {
        if ( validBacteriaEntity == null ) {
            return null;
        }

        BacAndPhageInfo bacAndPhageInfo = new BacAndPhageInfo();

        bacAndPhageInfo.setName( validBacteriaEntity.getName() );
        bacAndPhageInfo.setSeqId( validBacteriaEntity.getSeqId() );
        bacAndPhageInfo.setTaxonId( validBacteriaEntity.getTaxonId() );

        return bacAndPhageInfo;
    }

    protected BacAndPhageInfo validPhageEntityToBacAndPhageInfo(ValidPhageEntity validPhageEntity) {
        if ( validPhageEntity == null ) {
            return null;
        }

        BacAndPhageInfo bacAndPhageInfo = new BacAndPhageInfo();

        bacAndPhageInfo.setName( validPhageEntity.getName() );
        bacAndPhageInfo.setSeqId( validPhageEntity.getSeqId() );
        bacAndPhageInfo.setTaxonId( validPhageEntity.getTaxonId() );

        return bacAndPhageInfo;
    }
}
