package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links23 extends RefSpecCase {

  public Links23() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[*foo\\!*][bar]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[bar]: /url \"title\"");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/url\" title=\"title\"><em>foo!</em></a></p>");
    return sb.toString();
  }
}