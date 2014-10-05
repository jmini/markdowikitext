package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links48 extends RefSpecCase {

  public Links48() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo][bar][baz]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[baz]: /url1");
    sb.append(BR);
    sb.append("[foo]: /url2");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>[foo]<a href=\"/url1\">bar</a></p>");
    return sb.toString();
  }
}
