package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems12 extends RefSpecCase {

  public ListItems12() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("  10.  foo");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("           bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ol start=\"10\">");
    sb.append(BR);
    sb.append("<li><p>foo</p>");
    sb.append(BR);
    sb.append("<pre><code>bar");
    sb.append(BR);
    sb.append("</code></pre></li>");
    sb.append(BR);
    sb.append("</ol>");
    return sb.toString();
  }
}