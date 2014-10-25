package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class SetextHeaders13 extends RefSpecCase {

  public SetextHeaders13() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("---");
    sb.append(BR);
    sb.append("Foo");
    sb.append(BR);
    sb.append("---");
    sb.append(BR);
    sb.append("Bar");
    sb.append(BR);
    sb.append("---");
    sb.append(BR);
    sb.append("Baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<hr />");
    sb.append(BR);
    sb.append("<h2>Foo</h2>");
    sb.append(BR);
    sb.append("<h2>Bar</h2>");
    sb.append(BR);
    sb.append("<p>Baz</p>");
    return sb.toString();
  }
}