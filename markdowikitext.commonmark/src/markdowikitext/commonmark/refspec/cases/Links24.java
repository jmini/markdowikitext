package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links24 extends RefSpecCase {

  public Links24() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo][BaR]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[bar]: /url \"title\"");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/url\" title=\"title\">foo</a></p>");
    return sb.toString();
  }
}
