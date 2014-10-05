package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BackslashEscapes10 extends RefSpecCase {

  public BackslashEscapes10() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<a href=\"/bar\\/)\">");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/bar\\/)\"></p>");
    return sb.toString();
  }
}
