package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Lists16 extends RefSpecCase {

  public Lists16() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- a");
    sb.append(BR);
    sb.append("  > b");
    sb.append(BR);
    sb.append("  ```");
    sb.append(BR);
    sb.append("  c");
    sb.append(BR);
    sb.append("  ```");
    sb.append(BR);
    sb.append("- d");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>a");
    sb.append(BR);
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<p>b</p>");
    sb.append(BR);
    sb.append("</blockquote>");
    sb.append(BR);
    sb.append("<pre><code>c");
    sb.append(BR);
    sb.append("</code></pre></li>");
    sb.append(BR);
    sb.append("<li>d</li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}
