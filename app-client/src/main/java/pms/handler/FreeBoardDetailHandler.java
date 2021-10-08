package pms.handler;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import pms.domain.Comment;
import pms.domain.FreeBoard;
import pms.domain.Like;
import request.RequestAgent;
import util.Prompt;

public class FreeBoardDetailHandler implements Command { 

  RequestAgent requestAgent;


  public FreeBoardDetailHandler(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[상세보기] 페이지입니다.");
    System.out.println();
    String loginUser = AuthLoginHandler.getLoginUser().getId();
    int no = Prompt.inputInt("게시글 번호> ");

    // 게시글 번호를 no에 저장
    HashMap<String,String> params = new HashMap<>();
    params.put("no", String.valueOf(no));

    requestAgent.request("freeBoard.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    FreeBoard freeBoard = requestAgent.getObject(FreeBoard.class);

    System.out.printf("제목: %s\n", freeBoard.getTitle());
    System.out.printf("내용: %s\n", freeBoard.getContent());
    System.out.printf("작성자: %s\n", freeBoard.getWriter().getId()); // 우리는 익명이기 때문에 Id로
    System.out.printf("등록일: %s\n", freeBoard.getRegisteredDate());

    freeBoard.setViewCount(freeBoard.getViewCount() + 1);
    System.out.printf("조회수: %d\n", freeBoard.getViewCount());

    String whichBoard = freeBoard.getWhichBoard();


    requestAgent.request("like.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      System.out.print("[좋아요 ♡ : 0]");
    } else {

      List<Like> likeList = (List<Like>) requestAgent.getObjects(Like.class);

      for (int i = 0; i < likeList.size(); i++) {
        if (likeList.get(i).getLikeBoardNo() == freeBoard.getNo() && 
            likeList.get(i).getWhichBoard().equals(whichBoard) &&
            likeList.get(i).getLiker().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
          System.out.print("[좋아요 ♥ :");
          break;
        } else if (i == (likeList.size() - 1)) {
          System.out.print("[좋아요 ♡ :");
          break;
        }
      }

      int count = 0;
      for (int j = 0; j < likeList.size(); j++) {
        if (likeList.get(j).getLikeBoardNo() != 0) {
          if (likeList.get(j).getLikeBoardNo() == freeBoard.getNo() && 
              likeList.get(j).getWhichBoard().equals(whichBoard)) {
            count++;
          }
        }   
      }

      System.out.printf(" %d]\n", count);
    }

    System.out.println();
    System.out.println("[댓글]");

    requestAgent.request("comment.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    } else {

      Collection<Comment> commentList = requestAgent.getObjects(Comment.class);

      for (Comment comment : commentList) {
        if (comment.getCommentBoardNo() != 0) {
          if (comment.getCommentBoardNo() == freeBoard.getNo() && 
              comment.getWhichBoard().equals(whichBoard)) {
            System.out.printf("%d. %s, %s\n",
                comment.getNo(),
                comment.getCommenter(),
                comment.getCommentContent());
          }
        }   
      }
    }

    System.out.println();
    request.setAttribute("no", no); //게시글 번호 num에 저장
    request.setAttribute("boardType", "freeBoard");

    while(true) {
      String status = "";

      requestAgent.request("like.selectList", null);

      if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
        status = Prompt.inputString("[좋아요♡(#) / 신고하기🚨(!) /\n"
            + "댓글달기💬(@) / 넘어가기(Enter)]> ");
      } else {
        List<Like> likeList = (List<Like>) requestAgent.getObjects(Like.class);

        for (int i = 0; i < likeList.size(); i++) {
          if (likeList.get(i).getLiker().getId().equals(AuthLoginHandler.getLoginUser().getId()) &&
              likeList.get(i).getWhichBoard().equals(whichBoard)) {
            status = Prompt.inputString("[좋아요 취소💔(#) / 신고하기🚨(!) /\n"
                + "댓글달기💬(@) / 넘어가기(Enter)]> ");
            break;
          }  else if (i == likeList.size() - 1) {
            status = Prompt.inputString("[좋아요♡(#) / 신고하기🚨(!) /\\n"
                + "댓글달기💬(@) / 넘어가기(Enter)]> ");
          }
        }
      }


      if (status.equals("#")) {
        request.getRequestDispatcher("/like/addCancel").forward(request);
        return;

      } else if (status.equals("@")) {
        request.getRequestDispatcher("/comment/add").forward(request);
        return;

      } else if (status.equals("!")) {

        freeBoard.setReason(Prompt.inputString("신고 사유를 작성해 주세요> "));
        freeBoard.setRequester(loginUser);
        requestAgent.request("request.add", freeBoard);
        System.out.println("신고 접수가 완료되었습니다. 깨끗한 게시판 문화를 만드는데 도움을 주셔서 감사합니다!");
        break;

      } else if (status.equals("")){
        break;
      } else {
        System.out.println("메뉴에 맞는 명령어를 입력해 주세요.");
        continue;
      }

    } 

    int myComment = 0;
    requestAgent.request("comment.selectList", null);
    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    } else {

      Collection<Comment> commentList = requestAgent.getObjects(Comment.class);
      for (Comment comment : commentList) {
        if (comment.getCommentBoardNo() != 0) {
          if (comment.getCommentBoardNo() == freeBoard.getNo() && 
              comment.getWhichBoard().equals(whichBoard) &&
              comment.getCommenter().equals(loginUser)) {
            myComment++;
          }
        }   
      }
    }


    //내 댓글도 있고 내가 게시글 글쓴이일 때
    if (myComment != 0 && freeBoard.getWriter().getId().equals(loginUser)) {
      while (true) {
        System.out.println();
        String input = Prompt.inputString("[글] 변경(U) / 삭제(D) /\n"
            + "[댓글] 변경(M) / 삭제(R) / 이전 메뉴(0)> ");
        switch (input) {
          case "U":
          case "u":
            request.getRequestDispatcher("/freeBoard/update").forward(request);
            return;
          case "D":
          case "d":
            request.getRequestDispatcher("/freeBoard/delete").forward(request);
            return;
          case "M":
          case "m":
            request.getRequestDispatcher("/comment/update").forward(request);
            return;
          case "R":
          case "r":
            request.getRequestDispatcher("/comment/delete").forward(request);
            return;
          case "0":
            return;
          default:
            System.out.println("명령어가 올바르지 않습니다!");
        }
      }

      // 내 댓글이 없고 내가 게시글 글쓴이일 때 
    } else if (myComment == 0 && freeBoard.getWriter().getId().equals(loginUser)) {
      while (true) {
        System.out.println();
        String input = Prompt.inputString("[글] 변경(U) / 삭제(D) / 이전 메뉴(0)> ");
        switch (input) {
          case "U":
          case "u":
            request.getRequestDispatcher("/freeBoard/update").forward(request);
            return;
          case "D":
          case "d":
            request.getRequestDispatcher("/freeBoard/delete").forward(request);
            return;
          case "0":
            return;
          default:
            System.out.println("명령어가 올바르지 않습니다!");
        }
      }

      // 내 댓글이 있고 내가 게시글 글쓴이가 아닐 때
    } else if (myComment == 0 && freeBoard.getWriter().getId().equals(loginUser)) {
      while (true) {
        System.out.println();
        String input = Prompt.inputString("[댓글] 변경(M) / 삭제(R) / 이전 메뉴(0)> ");
        switch (input) {
          case "M":
          case "m":
            request.getRequestDispatcher("/comment/update").forward(request);
            return;
          case "R":
          case "r":
            request.getRequestDispatcher("/comment/delete").forward(request);
            return;
          case "0":
            return;
          default:
            System.out.println("명령어가 올바르지 않습니다!");
        }
      }
    }

  }
}


