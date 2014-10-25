package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class FencedCodeBlocks15 extends RefSpecCase {

  public FencedCodeBlocks15() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("``` ```");
    sb.append(BR);
    sb.append("aaa");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><code></code>");
    sb.append(BR);
    sb.append("aaa</p>");
    return sb.toString();
  }
}