package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BackslashEscapes02 extends RefSpecCase {

  public BackslashEscapes02() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("\\\t\\A\\a\\ \\3\\φ\\«");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>\\   \\A\\a\\ \\3\\φ\\«</p>");
    return sb.toString();
  }
}
