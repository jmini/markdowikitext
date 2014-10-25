package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Lists13 extends RefSpecCase {

  public Lists13() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- a");
    sb.append(BR);
    sb.append("- ```");
    sb.append(BR);
    sb.append("  b");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("  ```");
    sb.append(BR);
    sb.append("- c");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>a</li>");
    sb.append(BR);
    sb.append("<li><pre><code>b");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("</code></pre></li>");
    sb.append(BR);
    sb.append("<li>c</li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}