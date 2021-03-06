package apus.listener;

import java.util.Map;
import apus.context.ApplicationContextListener;

public class AppInitListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String,Object> params) {
    System.out.println("\r\n"
        + "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣ |\r\n"
        + "|[APUJIMA]에 오신 것을 환영합니다.|\r\n"
        + "|＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿ |\r\n"
        + "(\\__/) ||\r\n"
        + "(•ㅅ•).||\r\n"
        + "/ . . . .づ\r\n"
        + "");
  }

  @Override
  public void contextDestroyed(Map<String,Object> params) {
    System.out.println("\n"
        + "  (\\_(\\\n"
        + "(„• ֊ •„)\n"
        + "(  O☕️O  )"); 
    System.out.println("[APUJIMA]에 방문해 주셔서 감사합니다. 좋은하루 되시기 바랍니다!");
    System.out.println();
  }

}
