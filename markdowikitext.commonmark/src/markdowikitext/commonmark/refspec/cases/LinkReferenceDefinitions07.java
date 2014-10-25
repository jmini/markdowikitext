package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions07 extends RefSpecCase {

  public LinkReferenceDefinitions07() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo]: url");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"url\">foo</a></p>");
    return sb.toString();
  }
}