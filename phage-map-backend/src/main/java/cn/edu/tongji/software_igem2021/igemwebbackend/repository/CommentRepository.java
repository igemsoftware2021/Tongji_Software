package cn.edu.tongji.software_igem2021.igemwebbackend.repository;

import cn.edu.tongji.software_igem2021.igemwebbackend.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> getCommentEntitiesByIdIsNotOrderByTimeDesc(int id);
}
