package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class IndentedCodeBlocks06 extends RefSpecCase {

  public IndentedCodeBlocks06() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("    foo");
    sb.append(BR);
    sb.append("bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>foo");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("<p>bar</p>");
    return sb.toString();
  }
}
