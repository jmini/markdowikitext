package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HorizontalRules18 extends RefSpecCase {

  public HorizontalRules18() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("* Foo");
    sb.append(BR);
    sb.append("* * *");
    sb.append(BR);
    sb.append("* Bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>Foo</li>");
    sb.append(BR);
    sb.append("</ul>");
    sb.append(BR);
    sb.append("<hr />");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>Bar</li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}