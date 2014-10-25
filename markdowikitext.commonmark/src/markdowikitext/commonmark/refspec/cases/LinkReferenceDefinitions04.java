package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions04 extends RefSpecCase {

  public LinkReferenceDefinitions04() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[Foo bar]:");
    sb.append(BR);
    sb.append("<my url>");
    sb.append(BR);
    sb.append("'title'");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[Foo bar]");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"my%20url\" title=\"title\">Foo bar</a></p>");
    return sb.toString();
  }
}