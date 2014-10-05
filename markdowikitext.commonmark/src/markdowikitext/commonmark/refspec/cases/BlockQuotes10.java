package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BlockQuotes10 extends RefSpecCase {

  public BlockQuotes10() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("> ```");
    sb.append(BR);
    sb.append("foo");
    sb.append(BR);
    sb.append("```");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<pre><code></code></pre>");
    sb.append(BR);
    sb.append("</blockquote>");
    sb.append(BR);
    sb.append("<p>foo</p>");
    sb.append(BR);
    sb.append("<pre><code></code></pre>");
    return sb.toString();
  }
}
