package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Autolinks12 extends RefSpecCase {

  public Autolinks12() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<localhost:5001/foo>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>&lt;localhost:5001/foo&gt;</p>");
    return sb.toString();
  }
}
