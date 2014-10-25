package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class CodeSpan05 extends RefSpecCase {

  public CodeSpan05() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("`foo   bar");
    sb.append(BR);
    sb.append("  baz`");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><code>foo bar baz</code></p>");
    return sb.toString();
  }
}