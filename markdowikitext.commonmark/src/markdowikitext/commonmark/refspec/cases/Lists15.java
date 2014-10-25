package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Lists15 extends RefSpecCase {

  public Lists15() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("* a");
    sb.append(BR);
    sb.append("  > b");
    sb.append(BR);
    sb.append("  >");
    sb.append(BR);
    sb.append("* c");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>a");
    sb.append(BR);
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<p>b</p>");
    sb.append(BR);
    sb.append("</blockquote></li>");
    sb.append(BR);
    sb.append("<li>c</li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}