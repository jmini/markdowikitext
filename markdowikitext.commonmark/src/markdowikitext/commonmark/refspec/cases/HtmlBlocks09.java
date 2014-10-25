package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HtmlBlocks09 extends RefSpecCase {

  public HtmlBlocks09() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("Foo");
    sb.append(BR);
    sb.append("<div>");
    sb.append(BR);
    sb.append("bar");
    sb.append(BR);
    sb.append("</div>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>Foo</p>");
    sb.append(BR);
    sb.append("<div>");
    sb.append(BR);
    sb.append("bar");
    sb.append(BR);
    sb.append("</div>");
    return sb.toString();
  }
}