package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BlockQuotes23 extends RefSpecCase {

  public BlockQuotes23() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append(">>> foo");
    sb.append(BR);
    sb.append("> bar");
    sb.append(BR);
    sb.append(">>baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<p>foo");
    sb.append(BR);
    sb.append("bar");
    sb.append(BR);
    sb.append("baz</p>");
    sb.append(BR);
    sb.append("</blockquote>");
    sb.append(BR);
    sb.append("</blockquote>");
    sb.append(BR);
    sb.append("</blockquote>");
    return sb.toString();
  }
}