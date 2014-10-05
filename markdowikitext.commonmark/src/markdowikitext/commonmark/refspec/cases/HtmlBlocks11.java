package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HtmlBlocks11 extends RefSpecCase {

  public HtmlBlocks11() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<div class");
    sb.append(BR);
    sb.append("foo");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<div class");
    sb.append(BR);
    sb.append("foo");
    return sb.toString();
  }
}
