package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class FencedCodeBlocks12 extends RefSpecCase {

  public FencedCodeBlocks12() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("  ```");
    sb.append(BR);
    sb.append("aaa");
    sb.append(BR);
    sb.append("  aaa");
    sb.append(BR);
    sb.append("aaa");
    sb.append(BR);
    sb.append("  ```");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>aaa");
    sb.append(BR);
    sb.append("aaa");
    sb.append(BR);
    sb.append("aaa");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}