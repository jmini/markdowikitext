package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Lists09 extends RefSpecCase {

  public Lists09() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- a");
    sb.append(BR);
    sb.append("- b");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("- c");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li><p>a</p></li>");
    sb.append(BR);
    sb.append("<li><p>b</p></li>");
    sb.append(BR);
    sb.append("<li><p>c</p></li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}