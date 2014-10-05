package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HtmlBlocks02 extends RefSpecCase {

  public HtmlBlocks02() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append(" <div>");
    sb.append(BR);
    sb.append("  *hello*");
    sb.append(BR);
    sb.append("         <foo><a>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append(" <div>");
    sb.append(BR);
    sb.append("  *hello*");
    sb.append(BR);
    sb.append("         <foo><a>");
    return sb.toString();
  }
}
