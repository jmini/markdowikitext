package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Lists04 extends RefSpecCase {

  public Lists04() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- foo");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("  bar");
    sb.append(BR);
    sb.append("- baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>foo</li>");
    sb.append(BR);
    sb.append("</ul>");
    sb.append(BR);
    sb.append("<p>bar</p>");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>baz</li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}