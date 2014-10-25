package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Preprocessing01 extends RefSpecCase {

  public Preprocessing01() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("\tfoo\tbaz\t\tbim");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>foo baz     bim");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}