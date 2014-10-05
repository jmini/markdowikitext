package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems32 extends RefSpecCase {

  public ListItems32() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("1. - 2. foo");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ol>");
    sb.append(BR);
    sb.append("<li><ul>");
    sb.append(BR);
    sb.append("<li><ol start=\"2\">");
    sb.append(BR);
    sb.append("<li>foo</li>");
    sb.append(BR);
    sb.append("</ol></li>");
    sb.append(BR);
    sb.append("</ul></li>");
    sb.append(BR);
    sb.append("</ol>");
    return sb.toString();
  }
}
