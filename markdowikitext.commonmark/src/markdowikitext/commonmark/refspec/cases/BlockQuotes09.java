package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BlockQuotes09 extends RefSpecCase {

  public BlockQuotes09() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append(">     foo");
    sb.append(BR);
    sb.append("    bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<pre><code>foo");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("</blockquote>");
    sb.append(BR);
    sb.append("<pre><code>bar");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
