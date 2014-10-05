package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions01 extends RefSpecCase {

  public LinkReferenceDefinitions01() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo]: /url \"title\"");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo]");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/url\" title=\"title\">foo</a></p>");
    return sb.toString();
  }
}
