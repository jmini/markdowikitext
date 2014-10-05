package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class RawHtml12 extends RefSpecCase {

  public RawHtml12() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("foo <!-- this is a");
    sb.append(BR);
    sb.append("comment - with hyphen -->");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>foo <!-- this is a");
    sb.append(BR);
    sb.append("comment - with hyphen --></p>");
    return sb.toString();
  }
}
