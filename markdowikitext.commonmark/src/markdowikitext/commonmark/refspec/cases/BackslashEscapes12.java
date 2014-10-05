package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BackslashEscapes12 extends RefSpecCase {

  public BackslashEscapes12() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo]: /bar\\* \"ti\\*tle\"");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/bar*\" title=\"ti*tle\">foo</a></p>");
    return sb.toString();
  }
}
