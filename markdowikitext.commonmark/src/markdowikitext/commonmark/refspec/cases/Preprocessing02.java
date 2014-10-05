package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Preprocessing02 extends RefSpecCase {

  public Preprocessing02() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("    a\ta");
    sb.append(BR);
    sb.append("    ὐ\ta");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>a   a");
    sb.append(BR);
    sb.append("ὐ   a");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
