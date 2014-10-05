package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis09 extends RefSpecCase {

  public EmphasisAndStrongEmphasis09() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("*foo [bar](/url)*");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><em>foo <a href=\"/url\">bar</a></em></p>");
    return sb.toString();
  }
}
