package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links07 extends RefSpecCase {

  public Links07() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[link](foo");
    sb.append(BR);
    sb.append("bar)");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>[link](foo");
    sb.append(BR);
    sb.append("bar)</p>");
    return sb.toString();
  }
}
