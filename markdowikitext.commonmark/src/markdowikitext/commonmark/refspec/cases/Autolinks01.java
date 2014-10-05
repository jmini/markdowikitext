package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Autolinks01 extends RefSpecCase {

  public Autolinks01() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<http://foo.bar.baz>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"http://foo.bar.baz\">http://foo.bar.baz</a></p>");
    return sb.toString();
  }
}
