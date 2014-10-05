package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Lists02 extends RefSpecCase {

  public Lists02() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("1. foo");
    sb.append(BR);
    sb.append("2. bar");
    sb.append(BR);
    sb.append("3) baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ol>");
    sb.append(BR);
    sb.append("<li>foo</li>");
    sb.append(BR);
    sb.append("<li>bar</li>");
    sb.append(BR);
    sb.append("</ol>");
    sb.append(BR);
    sb.append("<ol start=\"3\">");
    sb.append(BR);
    sb.append("<li>baz</li>");
    sb.append(BR);
    sb.append("</ol>");
    return sb.toString();
  }
}
