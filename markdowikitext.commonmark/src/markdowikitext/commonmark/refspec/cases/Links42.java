package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links42 extends RefSpecCase {

  public Links42() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[[[foo]]]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[[[foo]]]: /url");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/url\">[[foo]]</a></p>");
    return sb.toString();
  }
}