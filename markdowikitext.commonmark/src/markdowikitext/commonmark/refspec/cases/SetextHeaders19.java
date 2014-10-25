package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class SetextHeaders19 extends RefSpecCase {

  public SetextHeaders19() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("\\> foo");
    sb.append(BR);
    sb.append("------");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h2>&gt; foo</h2>");
    return sb.toString();
  }
}