package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links19 extends RefSpecCase {

  public Links19() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[link](   /uri");
    sb.append(BR);
    sb.append("  \"title\"  )");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/uri\" title=\"title\">link</a></p>");
    return sb.toString();
  }
}