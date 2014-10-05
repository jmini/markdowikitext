package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Entities08 extends RefSpecCase {

  public Entities08() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo](/f&ouml;&ouml; \"f&ouml;&ouml;\")");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/f%C3%B6%C3%B6\" title=\"föö\">foo</a></p>");
    return sb.toString();
  }
}
