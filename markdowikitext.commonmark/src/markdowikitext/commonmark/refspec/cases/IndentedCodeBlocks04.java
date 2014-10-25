package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class IndentedCodeBlocks04 extends RefSpecCase {

  public IndentedCodeBlocks04() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("    chunk1");
    sb.append(BR);
    sb.append("      ");
    sb.append(BR);
    sb.append("      chunk2");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>chunk1");
    sb.append(BR);
    sb.append("  ");
    sb.append(BR);
    sb.append("  chunk2");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}