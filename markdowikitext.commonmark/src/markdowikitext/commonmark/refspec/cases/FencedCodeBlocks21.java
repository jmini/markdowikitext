package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class FencedCodeBlocks21 extends RefSpecCase {

  public FencedCodeBlocks21() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("````;");
    sb.append(BR);
    sb.append("````");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code class=\"language-;\"></code></pre>");
    return sb.toString();
  }
}