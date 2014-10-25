package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class CodeSpan04 extends RefSpecCase {

  public CodeSpan04() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("``");
    sb.append(BR);
    sb.append("foo");
    sb.append(BR);
    sb.append("``");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><code>foo</code></p>");
    return sb.toString();
  }
}