package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class SetextHeaders05 extends RefSpecCase {

  public SetextHeaders05() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("Foo");
    sb.append(BR);
    sb.append("   ----      ");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h2>Foo</h2>");
    return sb.toString();
  }
}
