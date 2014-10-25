package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems01 extends RefSpecCase {

  public ListItems01() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("A paragraph");
    sb.append(BR);
    sb.append("with two lines.");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("    indented code");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("> A block quote.");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>A paragraph");
    sb.append(BR);
    sb.append("with two lines.</p>");
    sb.append(BR);
    sb.append("<pre><code>indented code");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<p>A block quote.</p>");
    sb.append(BR);
    sb.append("</blockquote>");
    return sb.toString();
  }
}