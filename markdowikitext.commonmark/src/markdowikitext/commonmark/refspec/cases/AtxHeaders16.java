package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class AtxHeaders16 extends RefSpecCase {

  public AtxHeaders16() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("Foo bar");
    sb.append(BR);
    sb.append("# baz");
    sb.append(BR);
    sb.append("Bar foo");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>Foo bar</p>");
    sb.append(BR);
    sb.append("<h1>baz</h1>");
    sb.append(BR);
    sb.append("<p>Bar foo</p>");
    return sb.toString();
  }
}
