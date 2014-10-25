package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links25 extends RefSpecCase {

  public Links25() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[Толпой][Толпой] is a Russian word.");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[ТОЛПОЙ]: /url");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/url\">Толпой</a> is a Russian word.</p>");
    return sb.toString();
  }
}