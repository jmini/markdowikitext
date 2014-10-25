package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions09 extends RefSpecCase {

  public LinkReferenceDefinitions09() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[FOO]: /url");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[Foo]");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/url\">Foo</a></p>");
    return sb.toString();
  }
}