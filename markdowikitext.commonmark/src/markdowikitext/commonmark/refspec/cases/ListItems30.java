package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems30 extends RefSpecCase {

  public ListItems30() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("10) foo");
    sb.append(BR);
    sb.append("   - bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ol start=\"10\">");
    sb.append(BR);
    sb.append("<li>foo</li>");
    sb.append(BR);
    sb.append("</ol>");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>bar</li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}
