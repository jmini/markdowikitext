package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class SetextHeaders17 extends RefSpecCase {

  public SetextHeaders17() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("    foo");
    sb.append(BR);
    sb.append("---");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>foo");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("<hr />");
    return sb.toString();
  }
}