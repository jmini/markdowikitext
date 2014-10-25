package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Lists19 extends RefSpecCase {

  public Lists19() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("* foo");
    sb.append(BR);
    sb.append("  * bar");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("  baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li><p>foo</p>");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>bar</li>");
    sb.append(BR);
    sb.append("</ul>");
    sb.append(BR);
    sb.append("<p>baz</p></li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}