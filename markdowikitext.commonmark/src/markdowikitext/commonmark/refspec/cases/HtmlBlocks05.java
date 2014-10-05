package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HtmlBlocks05 extends RefSpecCase {

  public HtmlBlocks05() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<!-- Foo");
    sb.append(BR);
    sb.append("bar");
    sb.append(BR);
    sb.append("   baz -->");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<!-- Foo");
    sb.append(BR);
    sb.append("bar");
    sb.append(BR);
    sb.append("   baz -->");
    return sb.toString();
  }
}
