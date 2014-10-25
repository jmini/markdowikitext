package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class CodeSpan10 extends RefSpecCase {

  public CodeSpan10() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<http://foo.bar.`baz>`");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"http://foo.bar.%60baz\">http://foo.bar.`baz</a>`</p>");
    return sb.toString();
  }
}