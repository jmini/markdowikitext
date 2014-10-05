package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HtmlBlocks03 extends RefSpecCase {

  public HtmlBlocks03() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<DIV CLASS=\"foo\">");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("*Markdown*");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("</DIV>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<DIV CLASS=\"foo\">");
    sb.append(BR);
    sb.append("<p><em>Markdown</em></p>");
    sb.append(BR);
    sb.append("</DIV>");
    return sb.toString();
  }
}
