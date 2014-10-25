package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Lists18 extends RefSpecCase {

  public Lists18() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- a");
    sb.append(BR);
    sb.append("  - b");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>a");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>b</li>");
    sb.append(BR);
    sb.append("</ul></li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}