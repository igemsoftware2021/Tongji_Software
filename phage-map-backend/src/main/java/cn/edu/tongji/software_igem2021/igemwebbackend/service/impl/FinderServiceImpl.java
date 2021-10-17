package cn.edu.tongji.software_igem2021.igemwebbackend.service.impl;

import cn.edu.tongji.software_igem2021.igemwebbackend.dto.BacAndPhageInfo;
import cn.edu.tongji.software_igem2021.igemwebbackend.dto.mappers.MapStructMapper;
import cn.edu.tongji.software_igem2021.igemwebbackend.model.*;
import cn.edu.tongji.software_igem2021.igemwebbackend.repository.BacteriaRepository;
import cn.edu.tongji.software_igem2021.igemwebbackend.repository.FinderRepository;
import cn.edu.tongji.software_igem2021.igemwebbackend.repository.PhageRepository;
import cn.edu.tongji.software_igem2021.igemwebbackend.service.FinderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FinderServiceImpl implements FinderService {
    @Resource
    private FinderRepository finderRepository;

    @Resource
    private BacteriaRepository bacteriaRepository;

    @Resource
    private PhageRepository phageRepository;

    @Override
    public List<ScoreWithNameEntity> searchForAll(String key) {

        Specification<ScoreWithNameEntity> spec = (root, criteriaQuery, criteriaBuilder) -> {
            ArrayList<Predicate> list = new ArrayList<>();
            if (!Objects.equals(key, "") && key != null) {
                Predicate bac_id = criteriaBuilder.like(root.get("genebankId").as(String.class), key);
                Predicate phage_id = criteriaBuilder.like(root.get("phageId").as(String.class), key);
                Predicate phage_name = criteriaBuilder.like(root.get("scientificName").as(String.class), "%" + key + "%");
                Predicate bac_name = criteriaBuilder.like(root.get("name").as(String.class), "%" + key + "%");

                list.add(bac_id);
                list.add(bac_name);
                list.add(phage_id);
                list.add(phage_name);
            }

            Predicate[] array = new Predicate[list.size()];
            Predicate[] predicates = list.toArray(array);

            return criteriaBuilder.or(predicates);
        };

        return finderRepository.findAll(spec);
    }

    @Override
    public List<ScoreWithNameEntity> searchForBacteria(String key) {
        return finderRepository.findAll(
                (Specification<ScoreWithNameEntity>) (root, criteriaQuery, criteriaBuilder) -> {
                    ArrayList<Predicate> list = new ArrayList<>();
                    if (!Objects.equals(key, "") && key != null) {
                        Predicate bac_id = criteriaBuilder.like(root.get("genebankId").as(String.class), key);
                        Predicate bac_name = criteriaBuilder.like(root.get("name").as(String.class), "%" + key + "%");
                        Predicate bac_txid = criteriaBuilder.like(root.get("bacteriaTxid").as(String.class), key);

                        list.add(bac_id);
                        list.add(bac_name);
                        list.add(bac_txid);
                    }

                    Predicate[] array = new Predicate[list.size()];
                    Predicate[] predicates = list.toArray(array);

                    return criteriaBuilder.or(predicates);
                });
    }

    @Override
    public List<ScoreWithNameEntity> searchForPhage(String key) {
        return finderRepository.findAll(new Specification<ScoreWithNameEntity>() {
            @Override
            public Predicate toPredicate(Root<ScoreWithNameEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                ArrayList<Predicate> list = new ArrayList<>();
                if (!Objects.equals(key, "") && key != null) {
                    Predicate phage_id = criteriaBuilder.like(root.get("phageId").as(String.class), key);
                    Predicate phage_name = criteriaBuilder.like(root.get("scientificName").as(String.class), "%" + key + "%");
                    Predicate phage_txid = criteriaBuilder.like(root.get("phageTxid").as(String.class), key);

                    list.add(phage_id);
                    list.add(phage_name);
                    list.add(phage_txid);
                }

                Predicate[] array = new Predicate[list.size()];
                Predicate[] predicates = list.toArray(array);

                return criteriaBuilder.or(predicates);
            }
        });
    }

    @Override
    public List<BacAndPhageInfo> querySuggestionForBacteria(String key, int pageNum) {

        List<ValidBacteriaEntity> ret = bacteriaRepository.findAll((Specification<ValidBacteriaEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            String searchKey = key + "%";
            ArrayList<Predicate> list = new ArrayList<>();
            Predicate name = criteriaBuilder.like(root.get("name").as(String.class), searchKey);
            Predicate genebankId = criteriaBuilder.like(root.get("seqId").as(String.class), searchKey);
            Predicate taxonId = criteriaBuilder.like(root.get("taxonId").as(String.class), searchKey);

            list.add(name);
            list.add(genebankId);
            list.add((taxonId));

            Predicate[] array = new Predicate[list.size()];
            Predicate[] predicates = list.toArray(array);

            return criteriaBuilder.or(predicates);
        }, getPage(pageNum))
                .toList();

        return MapStructMapper.INSTANCE.allToBacAndPhageInfo(ret);
    }

    @Override
    public List<BacAndPhageInfo> querySuggestionForPhage(String key, int pageNum) {

        List<ValidPhageEntity> ret = phageRepository.findAll((Specification<ValidPhageEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            String searchKey = key + "%";
            ArrayList<Predicate> predicates1 = new ArrayList<>();
            Predicate scientificName = criteriaBuilder.like(root.get("name").as(String.class), searchKey);
            Predicate seqId = criteriaBuilder.like(root.get("seqId").as(String.class), searchKey);
            Predicate taxonId = criteriaBuilder.like(root.get("taxonId").as(String.class), searchKey);

            predicates1.add(scientificName);
            predicates1.add(seqId);
            predicates1.add((taxonId));

            Predicate[] array = new Predicate[predicates1.size()];
            Predicate[] predicates = predicates1.toArray(array);

            return criteriaBuilder.or(predicates);
        }, getPage(pageNum))
                .toList();
        return MapStructMapper.INSTANCE.allToBacAndPhageInfo(ret);
    }

    @Override
    public List<BacAndPhageInfo> querySuggestionForAll(String key, int pageNum) {
        List<BacAndPhageInfo> ret = querySuggestionForBacteria(key, pageNum);
        ret.addAll(querySuggestionForPhage(key, pageNum));
        return ret;
    }

    private Pageable getPage(int pageNum) {
        return PageRequest.of(
                pageNum - 1,
                20,
                Sort.Direction.ASC,
                "name",
                "seqId"
        );
    }

}
