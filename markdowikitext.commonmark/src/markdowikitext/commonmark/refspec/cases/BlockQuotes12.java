package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BlockQuotes12 extends RefSpecCase {

  public BlockQuotes12() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append(">");
    sb.append(BR);
    sb.append(">  ");
    sb.append(BR);
    sb.append("> ");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("</blockquote>");
    return sb.toString();
  }
}