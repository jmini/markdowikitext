package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems34 extends RefSpecCase {

  public ListItems34() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("-");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li></li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}
