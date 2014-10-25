package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HardLineBreaks06 extends RefSpecCase {

  public HardLineBreaks06() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("*foo  ");
    sb.append(BR);
    sb.append("bar*");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><em>foo<br />");
    sb.append(BR);
    sb.append("bar</em></p>");
    return sb.toString();
  }
}