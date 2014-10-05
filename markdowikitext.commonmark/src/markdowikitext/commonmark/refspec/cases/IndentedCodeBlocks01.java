package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class IndentedCodeBlocks01 extends RefSpecCase {

  public IndentedCodeBlocks01() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("    a simple");
    sb.append(BR);
    sb.append("      indented code block");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>a simple");
    sb.append(BR);
    sb.append("  indented code block");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
