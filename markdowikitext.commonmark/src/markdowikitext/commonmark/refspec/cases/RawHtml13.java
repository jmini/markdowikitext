package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class RawHtml13 extends RefSpecCase {

  public RawHtml13() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("foo <!-- not a comment -- two hyphens -->");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>foo &lt;!-- not a comment -- two hyphens --&gt;</p>");
    return sb.toString();
  }
}
