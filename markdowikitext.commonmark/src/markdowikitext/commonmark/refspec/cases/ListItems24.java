package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems24 extends RefSpecCase {

  public ListItems24() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("  1.  A paragraph");
    sb.append(BR);
    sb.append("    with two lines.");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ol>");
    sb.append(BR);
    sb.append("<li>A paragraph");
    sb.append(BR);
    sb.append("with two lines.</li>");
    sb.append(BR);
    sb.append("</ol>");
    return sb.toString();
  }
}
