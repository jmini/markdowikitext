package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Lists05 extends RefSpecCase {

  public Lists05() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- foo");
    sb.append(BR);
    sb.append("  - bar");
    sb.append(BR);
    sb.append("    - baz");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("      bim");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>foo");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>bar");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>baz</li>");
    sb.append(BR);
    sb.append("</ul></li>");
    sb.append(BR);
    sb.append("</ul></li>");
    sb.append(BR);
    sb.append("</ul>");
    sb.append(BR);
    sb.append("<pre><code>  bim");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
