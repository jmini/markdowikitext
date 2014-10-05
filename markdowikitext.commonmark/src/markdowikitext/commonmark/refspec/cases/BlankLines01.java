package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BlankLines01 extends RefSpecCase {

  public BlankLines01() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("  ");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("aaa");
    sb.append(BR);
    sb.append("  ");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("# aaa");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("  ");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>aaa</p>");
    sb.append(BR);
    sb.append("<h1>aaa</h1>");
    return sb.toString();
  }
}
