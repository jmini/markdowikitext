package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class FencedCodeBlocks22 extends RefSpecCase {

  public FencedCodeBlocks22() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("``` aa ```");
    sb.append(BR);
    sb.append("foo");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><code>aa</code>");
    sb.append(BR);
    sb.append("foo</p>");
    return sb.toString();
  }
}
