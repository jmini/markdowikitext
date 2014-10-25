package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems13 extends RefSpecCase {

  public ListItems13() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("    indented code");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("paragraph");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("    more code");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>indented code");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("<p>paragraph</p>");
    sb.append(BR);
    sb.append("<pre><code>more code");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}