package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class RawHtml08 extends RefSpecCase {

  public RawHtml08() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("< a><");
    sb.append(BR);
    sb.append("foo><bar/ >");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>&lt; a&gt;&lt;");
    sb.append(BR);
    sb.append("foo&gt;&lt;bar/ &gt;</p>");
    return sb.toString();
  }
}
