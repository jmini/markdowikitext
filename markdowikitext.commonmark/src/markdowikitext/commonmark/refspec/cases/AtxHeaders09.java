package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class AtxHeaders09 extends RefSpecCase {

  public AtxHeaders09() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("foo");
    sb.append(BR);
    sb.append("    # bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>foo");
    sb.append(BR);
    sb.append("# bar</p>");
    return sb.toString();
  }
}