package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HtmlBlocks08 extends RefSpecCase {

  public HtmlBlocks08() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("  <!-- foo -->");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("    <!-- foo -->");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("  <!-- foo -->");
    sb.append(BR);
    sb.append("<pre><code>&lt;!-- foo --&gt;");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
