package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis11 extends RefSpecCase {

  public EmphasisAndStrongEmphasis11() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("**foo [bar](/url)**");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><strong>foo <a href=\"/url\">bar</a></strong></p>");
    return sb.toString();
  }
}
