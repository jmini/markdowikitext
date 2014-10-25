package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class AtxHeaders17 extends RefSpecCase {

  public AtxHeaders17() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("## ");
    sb.append(BR);
    sb.append("#");
    sb.append(BR);
    sb.append("### ###");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h2></h2>");
    sb.append(BR);
    sb.append("<h1></h1>");
    sb.append(BR);
    sb.append("<h3></h3>");
    return sb.toString();
  }
}