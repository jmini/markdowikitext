package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions18 extends RefSpecCase {

  public LinkReferenceDefinitions18() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("> [foo]: /url");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/url\">foo</a></p>");
    sb.append(BR);
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("</blockquote>");
    return sb.toString();
  }
}
