package cn.edu.tongji.software_igem2021.igemwebbackend.controller;

import cn.edu.tongji.software_igem2021.igemwebbackend.dto.Comment;
import cn.edu.tongji.software_igem2021.igemwebbackend.model.CommentEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.repository.CommentRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentBoard {

    @Resource
    private CommentRepository commentRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int addComment(@RequestBody Comment comment, HttpServletResponse response) {
        System.out.println(comment);
        if (
                comment.getFirstname().length() <= 20 && comment.getFirstname().length() > 0 &&
                comment.getLastname().length() <= 20 && comment.getLastname().length() > 0 &&
                comment.getContent().length() <= 512 && comment.getContent().length() > 0
        ) {
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setContent(comment.getContent());
            commentEntity.setFirstname(comment.getFirstname());
            commentEntity.setLastname(comment.getLastname());
            commentEntity.setTime(comment.getTime());
            commentRepository.save(commentEntity);
            response.setStatus(200);
            return commentEntity.getId();
        } else {
            response.setStatus(400);
        }
        return -1;
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public List<CommentEntity> getAllComments() {
        return commentRepository.getCommentEntitiesByIdIsNotOrderByTimeDesc(-1);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void removeComment(@PathVariable(value = "id") int id) {
        commentRepository.deleteById(id);
    }
}
