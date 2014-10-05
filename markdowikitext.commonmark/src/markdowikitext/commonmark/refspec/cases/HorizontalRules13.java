package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HorizontalRules13 extends RefSpecCase {

  public HorizontalRules13() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("_ _ _ _ a");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("a------");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>_ _ _ _ a</p>");
    sb.append(BR);
    sb.append("<p>a------</p>");
    return sb.toString();
  }
}
