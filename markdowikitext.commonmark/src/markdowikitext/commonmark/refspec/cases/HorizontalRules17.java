package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HorizontalRules17 extends RefSpecCase {

  public HorizontalRules17() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("Foo");
    sb.append(BR);
    sb.append("---");
    sb.append(BR);
    sb.append("bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h2>Foo</h2>");
    sb.append(BR);
    sb.append("<p>bar</p>");
    return sb.toString();
  }
}
