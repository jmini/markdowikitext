package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BackslashEscapes13 extends RefSpecCase {

  public BackslashEscapes13() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("``` foo\\+bar");
    sb.append(BR);
    sb.append("foo");
    sb.append(BR);
    sb.append("```");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code class=\"language-foo+bar\">foo");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
