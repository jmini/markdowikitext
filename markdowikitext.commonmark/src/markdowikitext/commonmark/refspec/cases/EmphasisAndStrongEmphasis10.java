package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis10 extends RefSpecCase {

  public EmphasisAndStrongEmphasis10() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("_foo [bar](/url)_");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><em>foo <a href=\"/url\">bar</a></em></p>");
    return sb.toString();
  }
}