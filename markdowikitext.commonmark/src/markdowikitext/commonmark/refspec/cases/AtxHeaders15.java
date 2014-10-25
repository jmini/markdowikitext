package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class AtxHeaders15 extends RefSpecCase {

  public AtxHeaders15() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("****");
    sb.append(BR);
    sb.append("## foo");
    sb.append(BR);
    sb.append("****");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<hr />");
    sb.append(BR);
    sb.append("<h2>foo</h2>");
    sb.append(BR);
    sb.append("<hr />");
    return sb.toString();
  }
}