package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Images18 extends RefSpecCase {

  public Images18() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("![Foo]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo]: /url \"title\"");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><img src=\"/url\" alt=\"Foo\" title=\"title\" /></p>");
    return sb.toString();
  }
}
