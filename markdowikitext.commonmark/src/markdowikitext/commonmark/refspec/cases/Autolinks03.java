package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Autolinks03 extends RefSpecCase {

  public Autolinks03() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<irc://foo.bar:2233/baz>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"irc://foo.bar:2233/baz\">irc://foo.bar:2233/baz</a></p>");
    return sb.toString();
  }
}