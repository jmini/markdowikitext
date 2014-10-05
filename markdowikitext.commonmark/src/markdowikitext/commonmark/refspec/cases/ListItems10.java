package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems10 extends RefSpecCase {

  public ListItems10() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("1.  foo");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("    ```");
    sb.append(BR);
    sb.append("    bar");
    sb.append(BR);
    sb.append("    ```");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("    baz");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("    > bam");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ol>");
    sb.append(BR);
    sb.append("<li><p>foo</p>");
    sb.append(BR);
    sb.append("<pre><code>bar");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("<p>baz</p>");
    sb.append(BR);
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<p>bam</p>");
    sb.append(BR);
    sb.append("</blockquote></li>");
    sb.append(BR);
    sb.append("</ol>");
    return sb.toString();
  }
}
