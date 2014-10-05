package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class SoftLineBreaks02 extends RefSpecCase {

  public SoftLineBreaks02() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("foo ");
    sb.append(BR);
    sb.append(" baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>foo");
    sb.append(BR);
    sb.append("baz</p>");
    return sb.toString();
  }
}
