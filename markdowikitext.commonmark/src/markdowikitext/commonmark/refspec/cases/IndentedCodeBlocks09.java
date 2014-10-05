package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class IndentedCodeBlocks09 extends RefSpecCase {

  public IndentedCodeBlocks09() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("");
    sb.append(BR);
    sb.append("    ");
    sb.append(BR);
    sb.append("    foo");
    sb.append(BR);
    sb.append("    ");
    sb.append(BR);
    sb.append("");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>foo");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
