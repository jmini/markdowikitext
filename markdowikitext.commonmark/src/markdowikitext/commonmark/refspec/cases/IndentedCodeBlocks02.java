package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class IndentedCodeBlocks02 extends RefSpecCase {

  public IndentedCodeBlocks02() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("    <a/>");
    sb.append(BR);
    sb.append("    *hi*");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("    - one");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>&lt;a/&gt;");
    sb.append(BR);
    sb.append("*hi*");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("- one");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
