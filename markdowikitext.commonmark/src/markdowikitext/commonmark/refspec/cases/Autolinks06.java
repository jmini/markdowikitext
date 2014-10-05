package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Autolinks06 extends RefSpecCase {

  public Autolinks06() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<foo@bar.baz.com>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"mailto:foo@bar.baz.com\">foo@bar.baz.com</a></p>");
    return sb.toString();
  }
}
