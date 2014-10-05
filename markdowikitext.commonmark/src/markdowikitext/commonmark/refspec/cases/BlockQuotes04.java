package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BlockQuotes04 extends RefSpecCase {

  public BlockQuotes04() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("    > # Foo");
    sb.append(BR);
    sb.append("    > bar");
    sb.append(BR);
    sb.append("    > baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>&gt; # Foo");
    sb.append(BR);
    sb.append("&gt; bar");
    sb.append(BR);
    sb.append("&gt; baz");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
