package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links29 extends RefSpecCase {

  public Links29() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo]: /url1");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo]: /url2");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[bar][foo]");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/url1\">bar</a></p>");
    return sb.toString();
  }
}
