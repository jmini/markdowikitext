package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links40 extends RefSpecCase {

  public Links40() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo*]: /url");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("*[foo*]");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>*<a href=\"/url\">foo*</a></p>");
    return sb.toString();
  }
}