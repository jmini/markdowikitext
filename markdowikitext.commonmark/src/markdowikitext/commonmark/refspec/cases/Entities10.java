package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Entities10 extends RefSpecCase {

  public Entities10() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("``` f&ouml;&ouml;");
    sb.append(BR);
    sb.append("foo");
    sb.append(BR);
    sb.append("```");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code class=\"language-föö\">foo");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
