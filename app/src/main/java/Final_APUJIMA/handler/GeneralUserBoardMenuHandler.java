package Final_APUJIMA.handler;

import Final_APUJIMA.domain.Freeboard;
import Final_APUJIMA.util.Prompt;

public class GeneralUserBoardMenuHandler {
  static final int MAX_LENGTH = 5;

  Freeboard[] freeboards = new Freeboard[MAX_LENGTH];
  int size = 0;

  public void add() {
    System.out.println();
    System.out.println("[새 게시글]");

    Freeboard freeboard = new Freeboard();

    freeboard.no = Prompt.inputInt("번호? ");
    freeboard.title = Prompt.inputString("제목? ");
    freeboard.content = Prompt.inputString("내용? ");
    System.out.println();
    this.freeboards[this.size++] = freeboard;
  }

  public void list() {
    System.out.println();
    System.out.println("[게시글 목록]");
    System.out.println();
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s\n", 
          this.freeboards[i].no, 
          this.freeboards[i].title, 
          this.freeboards[i].content);
    }
    System.out.println();
  }

  public void detail() {
    System.out.println();
    System.out.println("[게시글 상세보기]");
    System.out.println();
    int no = Prompt.inputInt("번호? ");

    Freeboard freeboard = findByNo(no);

    if (freeboard == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", freeboard.title);
    System.out.printf("내용: %s\n", freeboard.content);
    System.out.println();
  }

  public void update() {
    System.out.println();
    System.out.println("[게시글 변경]");
    System.out.println();
    int no = Prompt.inputInt("번호? ");

    Freeboard freeboard = findByNo(no);

    if (freeboard == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", freeboard.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", freeboard.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    freeboard.title = title;
    freeboard.content = content;
    System.out.println("게시글을 변경하였습니다.");
    System.out.println();
  }

  public void delete() {
    System.out.println();
    System.out.println("[게시글 삭제]");
    System.out.println();
    int no = Prompt.inputInt("번호? ");

    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.freeboards[i - 1] = this.freeboards[i];
    }
    this.freeboards[--this.size] = null;

    System.out.println("게시글을 삭제하였습니다.");
    System.out.println();
  }

  private Freeboard findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.freeboards[i].no == no) {
        return this.freeboards[i];
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.freeboards[i].no == no) {
        return i;
      }
    }
    return -1;
  }
}