package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Lists07 extends RefSpecCase {

  public Lists07() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("-   foo");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("    notcode");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("-   foo");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("    code");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li><p>foo</p>");
    sb.append(BR);
    sb.append("<p>notcode</p></li>");
    sb.append(BR);
    sb.append("<li><p>foo</p></li>");
    sb.append(BR);
    sb.append("</ul>");
    sb.append(BR);
    sb.append("<pre><code>code");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}