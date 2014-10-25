package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Precedence01 extends RefSpecCase {

  public Precedence01() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- `one");
    sb.append(BR);
    sb.append("- two`");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>`one</li>");
    sb.append(BR);
    sb.append("<li>two`</li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}