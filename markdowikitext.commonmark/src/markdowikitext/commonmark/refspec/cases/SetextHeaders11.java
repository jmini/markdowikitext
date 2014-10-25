package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class SetextHeaders11 extends RefSpecCase {

  public SetextHeaders11() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("> Foo");
    sb.append(BR);
    sb.append("---");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<p>Foo</p>");
    sb.append(BR);
    sb.append("</blockquote>");
    sb.append(BR);
    sb.append("<hr />");
    return sb.toString();
  }
}