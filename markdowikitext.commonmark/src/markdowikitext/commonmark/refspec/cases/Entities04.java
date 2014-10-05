package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Entities04 extends RefSpecCase {

  public Entities04() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("&nbsp &x; &#; &#x; &ThisIsWayTooLongToBeAnEntityIsntIt; &hi?;");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>&amp;nbsp &amp;x; &amp;#; &amp;#x; &amp;ThisIsWayTooLongToBeAnEntityIsntIt; &amp;hi?;</p>");
    return sb.toString();
  }
}
