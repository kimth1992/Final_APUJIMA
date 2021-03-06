package apus.dao;

import java.util.List;
import apus.domain.Comment;

public interface CommentDao {
  void insert(Comment comment) throws Exception;
  List<Comment> findAll() throws Exception;
  Comment findByNo(int no) throws Exception;
  void update(Comment comment) throws Exception;
  //  void delete(int no) throws Exception;
  // List<Comment> findByKeyword(String keyword) throws Exception;
  List<Comment> findBoardComment(int boardNo) throws Exception;
  void delete(int commentNo) throws Exception;
  void autoDelete(int boardNo) throws Exception;
  List<Comment> findById(String name) throws Exception;
}
