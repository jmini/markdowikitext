package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems33 extends RefSpecCase {

  public ListItems33() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- foo");
    sb.append(BR);
    sb.append("-");
    sb.append(BR);
    sb.append("- bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>foo</li>");
    sb.append(BR);
    sb.append("<li></li>");
    sb.append(BR);
    sb.append("<li>bar</li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}
