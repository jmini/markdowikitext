package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class AtxHeaders10 extends RefSpecCase {

  public AtxHeaders10() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("## foo ##");
    sb.append(BR);
    sb.append("  ###   bar    ###");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h2>foo</h2>");
    sb.append(BR);
    sb.append("<h3>bar</h3>");
    return sb.toString();
  }
}