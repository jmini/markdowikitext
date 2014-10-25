package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Entities09 extends RefSpecCase {

  public Entities09() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo]: /f&ouml;&ouml; \"f&ouml;&ouml;\"");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/f%C3%B6%C3%B6\" title=\"föö\">foo</a></p>");
    return sb.toString();
  }
}