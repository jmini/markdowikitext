package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BlockQuotes19 extends RefSpecCase {

  public BlockQuotes19() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("> bar");
    sb.append(BR);
    sb.append("baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<p>bar");
    sb.append(BR);
    sb.append("baz</p>");
    sb.append(BR);
    sb.append("</blockquote>");
    return sb.toString();
  }
}