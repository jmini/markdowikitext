package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Images12 extends RefSpecCase {

  public Images12() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("![*foo* bar][]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[*foo* bar]: /url \"title\"");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><img src=\"/url\" alt=\"&lt;em&gt;foo&lt;/em&gt; bar\" title=\"title\" /></p>");
    return sb.toString();
  }
}