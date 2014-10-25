package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class FencedCodeBlocks18 extends RefSpecCase {

  public FencedCodeBlocks18() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("foo");
    sb.append(BR);
    sb.append("---");
    sb.append(BR);
    sb.append("~~~");
    sb.append(BR);
    sb.append("bar");
    sb.append(BR);
    sb.append("~~~");
    sb.append(BR);
    sb.append("# baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h2>foo</h2>");
    sb.append(BR);
    sb.append("<pre><code>bar");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("<h1>baz</h1>");
    return sb.toString();
  }
}