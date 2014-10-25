package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions02 extends RefSpecCase {

  public LinkReferenceDefinitions02() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("   [foo]: ");
    sb.append(BR);
    sb.append("      /url  ");
    sb.append(BR);
    sb.append("           'the title'  ");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo]");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/url\" title=\"the title\">foo</a></p>");
    return sb.toString();
  }
}