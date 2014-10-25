package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class FencedCodeBlocks17 extends RefSpecCase {

  public FencedCodeBlocks17() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("foo");
    sb.append(BR);
    sb.append("```");
    sb.append(BR);
    sb.append("bar");
    sb.append(BR);
    sb.append("```");
    sb.append(BR);
    sb.append("baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>foo</p>");
    sb.append(BR);
    sb.append("<pre><code>bar");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("<p>baz</p>");
    return sb.toString();
  }
}