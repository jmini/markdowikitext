package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BackslashEscapes08 extends RefSpecCase {

  public BackslashEscapes08() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("~~~");
    sb.append(BR);
    sb.append("\\[\\]");
    sb.append(BR);
    sb.append("~~~");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>\\[\\]");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
