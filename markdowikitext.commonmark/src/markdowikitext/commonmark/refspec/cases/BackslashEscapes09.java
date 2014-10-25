package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BackslashEscapes09 extends RefSpecCase {

  public BackslashEscapes09() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<http://example.com?find=\\*>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"http://example.com?find=%5C*\">http://example.com?find=\\*</a></p>");
    return sb.toString();
  }
}