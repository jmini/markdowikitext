package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems14 extends RefSpecCase {

  public ListItems14() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("1.     indented code");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("   paragraph");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("       more code");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ol>");
    sb.append(BR);
    sb.append("<li><pre><code>indented code");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("<p>paragraph</p>");
    sb.append(BR);
    sb.append("<pre><code>more code");
    sb.append(BR);
    sb.append("</code></pre></li>");
    sb.append(BR);
    sb.append("</ol>");
    return sb.toString();
  }
}
