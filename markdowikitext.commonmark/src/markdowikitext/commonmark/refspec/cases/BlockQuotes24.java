package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BlockQuotes24 extends RefSpecCase {

  public BlockQuotes24() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append(">     code");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append(">    not code");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<pre><code>code");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("</blockquote>");
    sb.append(BR);
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<p>not code</p>");
    sb.append(BR);
    sb.append("</blockquote>");
    return sb.toString();
  }
}
