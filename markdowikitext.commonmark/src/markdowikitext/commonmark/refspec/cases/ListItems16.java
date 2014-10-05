package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems16 extends RefSpecCase {

  public ListItems16() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("   foo");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>foo</p>");
    sb.append(BR);
    sb.append("<p>bar</p>");
    return sb.toString();
  }
}
