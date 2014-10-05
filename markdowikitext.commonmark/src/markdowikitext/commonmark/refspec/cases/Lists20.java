package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Lists20 extends RefSpecCase {

  public Lists20() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- a");
    sb.append(BR);
    sb.append("  - b");
    sb.append(BR);
    sb.append("  - c");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("- d");
    sb.append(BR);
    sb.append("  - e");
    sb.append(BR);
    sb.append("  - f");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li><p>a</p>");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>b</li>");
    sb.append(BR);
    sb.append("<li>c</li>");
    sb.append(BR);
    sb.append("</ul></li>");
    sb.append(BR);
    sb.append("<li><p>d</p>");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>e</li>");
    sb.append(BR);
    sb.append("<li>f</li>");
    sb.append(BR);
    sb.append("</ul></li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}
