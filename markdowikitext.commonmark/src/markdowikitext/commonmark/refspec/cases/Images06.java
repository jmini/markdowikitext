package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Images06 extends RefSpecCase {

  public Images06() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("My ![foo bar](/path/to/train.jpg  \"title\"   )");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>My <img src=\"/path/to/train.jpg\" alt=\"foo bar\" title=\"title\" /></p>");
    return sb.toString();
  }
}