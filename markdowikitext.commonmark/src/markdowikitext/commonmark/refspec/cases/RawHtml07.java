package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class RawHtml07 extends RefSpecCase {

  public RawHtml07() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<a href=\"hi'> <a href=hi'>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>&lt;a href=&quot;hi'&gt; &lt;a href=hi'&gt;</p>");
    return sb.toString();
  }
}