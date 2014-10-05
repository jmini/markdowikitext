package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class RawHtml19 extends RefSpecCase {

  public RawHtml19() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<a href=\"\\\"\">");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>&lt;a href=&quot;&quot;&quot;&gt;</p>");
    return sb.toString();
  }
}
