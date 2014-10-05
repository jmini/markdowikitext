package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems07 extends RefSpecCase {

  public ListItems07() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("   > > 1.  one");
    sb.append(BR);
    sb.append(">>");
    sb.append(BR);
    sb.append(">>     two");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<ol>");
    sb.append(BR);
    sb.append("<li><p>one</p>");
    sb.append(BR);
    sb.append("<p>two</p></li>");
    sb.append(BR);
    sb.append("</ol>");
    sb.append(BR);
    sb.append("</blockquote>");
    sb.append(BR);
    sb.append("</blockquote>");
    return sb.toString();
  }
}
