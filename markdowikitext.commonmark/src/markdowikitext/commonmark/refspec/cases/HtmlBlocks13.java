package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HtmlBlocks13 extends RefSpecCase {

  public HtmlBlocks13() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<div>");
    sb.append(BR);
    sb.append("*Emphasized* text.");
    sb.append(BR);
    sb.append("</div>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<div>");
    sb.append(BR);
    sb.append("*Emphasized* text.");
    sb.append(BR);
    sb.append("</div>");
    return sb.toString();
  }
}