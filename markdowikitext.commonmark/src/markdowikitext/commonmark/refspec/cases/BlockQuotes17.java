package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BlockQuotes17 extends RefSpecCase {

  public BlockQuotes17() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("foo");
    sb.append(BR);
    sb.append("> bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>foo</p>");
    sb.append(BR);
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<p>bar</p>");
    sb.append(BR);
    sb.append("</blockquote>");
    return sb.toString();
  }
}
