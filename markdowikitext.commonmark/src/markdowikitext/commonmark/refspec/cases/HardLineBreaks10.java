package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HardLineBreaks10 extends RefSpecCase {

  public HardLineBreaks10() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<a href=\"foo  ");
    sb.append(BR);
    sb.append("bar\">");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"foo  ");
    sb.append(BR);
    sb.append("bar\"></p>");
    return sb.toString();
  }
}
