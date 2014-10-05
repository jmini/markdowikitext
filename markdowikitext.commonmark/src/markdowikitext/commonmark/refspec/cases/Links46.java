package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links46 extends RefSpecCase {

  public Links46() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo][bar][baz]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[baz]: /url");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>[foo]<a href=\"/url\">bar</a></p>");
    return sb.toString();
  }
}
