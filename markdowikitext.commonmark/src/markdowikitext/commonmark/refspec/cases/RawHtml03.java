package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class RawHtml03 extends RefSpecCase {

  public RawHtml03() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<a  /><b2");
    sb.append(BR);
    sb.append("data=\"foo\" >");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a  /><b2");
    sb.append(BR);
    sb.append("data=\"foo\" ></p>");
    return sb.toString();
  }
}