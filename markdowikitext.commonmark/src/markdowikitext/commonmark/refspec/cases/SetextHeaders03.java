package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class SetextHeaders03 extends RefSpecCase {

  public SetextHeaders03() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("   Foo");
    sb.append(BR);
    sb.append("---");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("  Foo");
    sb.append(BR);
    sb.append("-----");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("  Foo");
    sb.append(BR);
    sb.append("  ===");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h2>Foo</h2>");
    sb.append(BR);
    sb.append("<h2>Foo</h2>");
    sb.append(BR);
    sb.append("<h1>Foo</h1>");
    return sb.toString();
  }
}