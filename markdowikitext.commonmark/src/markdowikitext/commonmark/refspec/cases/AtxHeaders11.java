package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class AtxHeaders11 extends RefSpecCase {

  public AtxHeaders11() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("# foo ##################################");
    sb.append(BR);
    sb.append("##### foo ##");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h1>foo</h1>");
    sb.append(BR);
    sb.append("<h5>foo</h5>");
    return sb.toString();
  }
}