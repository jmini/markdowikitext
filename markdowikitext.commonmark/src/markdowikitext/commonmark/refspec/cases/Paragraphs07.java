package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Paragraphs07 extends RefSpecCase {

  public Paragraphs07() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("    aaa");
    sb.append(BR);
    sb.append("bbb");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>aaa");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("<p>bbb</p>");
    return sb.toString();
  }
}
