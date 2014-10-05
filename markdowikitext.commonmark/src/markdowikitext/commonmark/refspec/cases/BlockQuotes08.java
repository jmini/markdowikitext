package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BlockQuotes08 extends RefSpecCase {

  public BlockQuotes08() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("> - foo");
    sb.append(BR);
    sb.append("- bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>foo</li>");
    sb.append(BR);
    sb.append("</ul>");
    sb.append(BR);
    sb.append("</blockquote>");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>bar</li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}
