package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class SetextHeaders04 extends RefSpecCase {

  public SetextHeaders04() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("    Foo");
    sb.append(BR);
    sb.append("    ---");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("    Foo");
    sb.append(BR);
    sb.append("---");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>Foo");
    sb.append(BR);
    sb.append("---");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("Foo");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("<hr />");
    return sb.toString();
  }
}
