package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class RawHtml10 extends RefSpecCase {

  public RawHtml10() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("</a>");
    sb.append(BR);
    sb.append("</foo >");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p></a>");
    sb.append(BR);
    sb.append("</foo ></p>");
    return sb.toString();
  }
}