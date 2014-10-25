package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HtmlBlocks14 extends RefSpecCase {

  public HtmlBlocks14() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<table>");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("<tr>");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("<td>");
    sb.append(BR);
    sb.append("Hi");
    sb.append(BR);
    sb.append("</td>");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("</tr>");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("</table>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<table>");
    sb.append(BR);
    sb.append("<tr>");
    sb.append(BR);
    sb.append("<td>");
    sb.append(BR);
    sb.append("Hi");
    sb.append(BR);
    sb.append("</td>");
    sb.append(BR);
    sb.append("</tr>");
    sb.append(BR);
    sb.append("</table>");
    return sb.toString();
  }
}