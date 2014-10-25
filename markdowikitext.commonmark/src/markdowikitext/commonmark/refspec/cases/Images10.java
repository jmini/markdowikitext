package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Images10 extends RefSpecCase {

  public Images10() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("![foo] [bar]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[BAR]: /url");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><img src=\"/url\" alt=\"foo\" /></p>");
    return sb.toString();
  }
}