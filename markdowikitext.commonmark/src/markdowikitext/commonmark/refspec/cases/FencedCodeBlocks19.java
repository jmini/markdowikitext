package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class FencedCodeBlocks19 extends RefSpecCase {

  public FencedCodeBlocks19() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("```ruby");
    sb.append(BR);
    sb.append("def foo(x)");
    sb.append(BR);
    sb.append("  return 3");
    sb.append(BR);
    sb.append("end");
    sb.append(BR);
    sb.append("```");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code class=\"language-ruby\">def foo(x)");
    sb.append(BR);
    sb.append("  return 3");
    sb.append(BR);
    sb.append("end");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}