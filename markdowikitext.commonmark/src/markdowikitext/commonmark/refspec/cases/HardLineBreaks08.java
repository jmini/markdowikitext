package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HardLineBreaks08 extends RefSpecCase {

  public HardLineBreaks08() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("`code  ");
    sb.append(BR);
    sb.append("span`");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><code>code span</code></p>");
    return sb.toString();
  }
}
