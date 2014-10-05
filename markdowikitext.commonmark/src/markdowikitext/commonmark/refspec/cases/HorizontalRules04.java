package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HorizontalRules04 extends RefSpecCase {

  public HorizontalRules04() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("--");
    sb.append(BR);
    sb.append("**");
    sb.append(BR);
    sb.append("__");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>--");
    sb.append(BR);
    sb.append("**");
    sb.append(BR);
    sb.append("__</p>");
    return sb.toString();
  }
}
