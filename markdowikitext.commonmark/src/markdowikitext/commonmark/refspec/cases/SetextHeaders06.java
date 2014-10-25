package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class SetextHeaders06 extends RefSpecCase {

  public SetextHeaders06() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("Foo");
    sb.append(BR);
    sb.append("     ---");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>Foo");
    sb.append(BR);
    sb.append("---</p>");
    return sb.toString();
  }
}