package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Entities11 extends RefSpecCase {

  public Entities11() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("`f&ouml;&ouml;`");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><code>f&amp;ouml;&amp;ouml;</code></p>");
    return sb.toString();
  }
}
