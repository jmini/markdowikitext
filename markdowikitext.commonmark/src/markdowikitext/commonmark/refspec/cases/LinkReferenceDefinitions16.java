package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions16 extends RefSpecCase {

  public LinkReferenceDefinitions16() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("# [Foo]");
    sb.append(BR);
    sb.append("[foo]: /url");
    sb.append(BR);
    sb.append("> bar");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h1><a href=\"/url\">Foo</a></h1>");
    sb.append(BR);
    sb.append("<blockquote>");
    sb.append(BR);
    sb.append("<p>bar</p>");
    sb.append(BR);
    sb.append("</blockquote>");
    return sb.toString();
  }
}