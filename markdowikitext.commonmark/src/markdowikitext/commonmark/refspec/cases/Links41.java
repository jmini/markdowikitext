package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links41 extends RefSpecCase {

  public Links41() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo`]: /url");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo`]`");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>[foo<code>]</code></p>");
    return sb.toString();
  }
}