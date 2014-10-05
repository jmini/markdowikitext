package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems04 extends RefSpecCase {

  public ListItems04() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- one");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("  two");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li><p>one</p>");
    sb.append(BR);
    sb.append("<p>two</p></li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}
