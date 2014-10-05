package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HorizontalRules01 extends RefSpecCase {

  public HorizontalRules01() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("***");
    sb.append(BR);
    sb.append("---");
    sb.append(BR);
    sb.append("___");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<hr />");
    sb.append(BR);
    sb.append("<hr />");
    sb.append(BR);
    sb.append("<hr />");
    return sb.toString();
  }
}
