package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links26 extends RefSpecCase {

  public Links26() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[Foo");
    sb.append(BR);
    sb.append("  bar]: /url");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[Baz][Foo bar]");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/url\">Baz</a></p>");
    return sb.toString();
  }
}