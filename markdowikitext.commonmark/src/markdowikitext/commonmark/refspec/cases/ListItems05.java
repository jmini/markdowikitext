package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems05 extends RefSpecCase {

  public ListItems05() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append(" -    one");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("     two");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>one</li>");
    sb.append(BR);
    sb.append("</ul>");
    sb.append(BR);
    sb.append("<pre><code> two");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
