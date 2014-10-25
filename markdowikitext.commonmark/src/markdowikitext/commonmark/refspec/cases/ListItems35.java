package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems35 extends RefSpecCase {

  public ListItems35() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- # Foo");
    sb.append(BR);
    sb.append("- Bar");
    sb.append(BR);
    sb.append("  ---");
    sb.append(BR);
    sb.append("  baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li><h1>Foo</h1></li>");
    sb.append(BR);
    sb.append("<li><h2>Bar</h2>");
    sb.append(BR);
    sb.append("<p>baz</p></li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}