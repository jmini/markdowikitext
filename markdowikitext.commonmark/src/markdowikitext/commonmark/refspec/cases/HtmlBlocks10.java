package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HtmlBlocks10 extends RefSpecCase {

  public HtmlBlocks10() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<div>");
    sb.append(BR);
    sb.append("bar");
    sb.append(BR);
    sb.append("</div>");
    sb.append(BR);
    sb.append("*foo*");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<div>");
    sb.append(BR);
    sb.append("bar");
    sb.append(BR);
    sb.append("</div>");
    sb.append(BR);
    sb.append("*foo*");
    return sb.toString();
  }
}