package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class AtxHeaders05 extends RefSpecCase {

  public AtxHeaders05() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("# foo *bar* \\*baz\\*");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h1>foo <em>bar</em> *baz*</h1>");
    return sb.toString();
  }
}
