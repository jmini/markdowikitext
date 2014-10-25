package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Lists03 extends RefSpecCase {

  public Lists03() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- foo");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("- bar");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("- baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li><p>foo</p></li>");
    sb.append(BR);
    sb.append("<li><p>bar</p></li>");
    sb.append(BR);
    sb.append("</ul>");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>baz</li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}