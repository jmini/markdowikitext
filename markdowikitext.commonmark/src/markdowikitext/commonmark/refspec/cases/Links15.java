package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links15 extends RefSpecCase {

  public Links15() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[link](/url \"title\")");
    sb.append(BR);
    sb.append("[link](/url 'title')");
    sb.append(BR);
    sb.append("[link](/url (title))");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/url\" title=\"title\">link</a>");
    sb.append(BR);
    sb.append("<a href=\"/url\" title=\"title\">link</a>");
    sb.append(BR);
    sb.append("<a href=\"/url\" title=\"title\">link</a></p>");
    return sb.toString();
  }
}
