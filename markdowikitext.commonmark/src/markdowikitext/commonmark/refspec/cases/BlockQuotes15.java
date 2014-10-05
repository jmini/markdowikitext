package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BlockQuotes15 extends RefSpecCase {

  public BlockQuotes15() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("> foo");
    sb.append(BR);
    sb.append("> bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<p>foo");
    sb.append(BR);
    sb.append("bar</p>");
    sb.append(BR);
    sb.append("</blockquote>");
    return sb.toString();
  }
}
