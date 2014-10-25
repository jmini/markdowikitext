package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HardLineBreaks02 extends RefSpecCase {

  public HardLineBreaks02() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("foo\\");
    sb.append(BR);
    sb.append("baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>foo<br />");
    sb.append(BR);
    sb.append("baz</p>");
    return sb.toString();
  }
}