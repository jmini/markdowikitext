package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HtmlBlocks01 extends RefSpecCase {

  public HtmlBlocks01() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<table>");
    sb.append(BR);
    sb.append("  <tr>");
    sb.append(BR);
    sb.append("    <td>");
    sb.append(BR);
    sb.append("           hi");
    sb.append(BR);
    sb.append("    </td>");
    sb.append(BR);
    sb.append("  </tr>");
    sb.append(BR);
    sb.append("</table>");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("okay.");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<table>");
    sb.append(BR);
    sb.append("  <tr>");
    sb.append(BR);
    sb.append("    <td>");
    sb.append(BR);
    sb.append("           hi");
    sb.append(BR);
    sb.append("    </td>");
    sb.append(BR);
    sb.append("  </tr>");
    sb.append(BR);
    sb.append("</table>");
    sb.append(BR);
    sb.append("<p>okay.</p>");
    return sb.toString();
  }
}