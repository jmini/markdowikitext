package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems25 extends RefSpecCase {

  public ListItems25() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("> 1. > Blockquote");
    sb.append(BR);
    sb.append("continued here.");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<ol>");
    sb.append(BR);
    sb.append("<li><blockquote>");
    sb.append(BR);
    sb.append("<p>Blockquote");
    sb.append(BR);
    sb.append("continued here.</p>");
    sb.append(BR);
    sb.append("</blockquote></li>");
    sb.append(BR);
    sb.append("</ol>");
    sb.append(BR);
    sb.append("</blockquote>");
    return sb.toString();
  }
}
