package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Entities12 extends RefSpecCase {

  public Entities12() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("    f&ouml;f&ouml;");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>f&amp;ouml;f&amp;ouml;");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}