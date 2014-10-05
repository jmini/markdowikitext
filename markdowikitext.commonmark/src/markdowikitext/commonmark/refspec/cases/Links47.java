package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links47 extends RefSpecCase {

  public Links47() {
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
    sb.append("[bar]: /url2");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/url2\">foo</a><a href=\"/url1\">baz</a></p>");
    return sb.toString();
  }
}
