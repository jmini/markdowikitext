package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links30 extends RefSpecCase {

  public Links30() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[bar][foo\\!]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo!]: /url");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>[bar][foo!]</p>");
    return sb.toString();
  }
}
