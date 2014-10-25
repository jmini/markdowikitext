package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class FencedCodeBlocks02 extends RefSpecCase {

  public FencedCodeBlocks02() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("~~~");
    sb.append(BR);
    sb.append("<");
    sb.append(BR);
    sb.append(" >");
    sb.append(BR);
    sb.append("~~~");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>&lt;");
    sb.append(BR);
    sb.append(" &gt;");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}