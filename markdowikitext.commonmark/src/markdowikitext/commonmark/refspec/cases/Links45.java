package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links45 extends RefSpecCase {

  public Links45() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo][bar]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo]: /url1");
    sb.append(BR);
    sb.append("[bar]: /url2");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/url2\">foo</a></p>");
    return sb.toString();
  }
}
