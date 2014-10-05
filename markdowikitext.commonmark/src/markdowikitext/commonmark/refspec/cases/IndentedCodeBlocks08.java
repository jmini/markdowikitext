package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class IndentedCodeBlocks08 extends RefSpecCase {

  public IndentedCodeBlocks08() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("        foo");
    sb.append(BR);
    sb.append("    bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>    foo");
    sb.append(BR);
    sb.append("bar");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
