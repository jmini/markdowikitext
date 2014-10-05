package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions03 extends RefSpecCase {

  public LinkReferenceDefinitions03() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[Foo*bar\\]]:my_(url) 'title (with parens)'");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[Foo*bar\\]]");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"my_(url)\" title=\"title (with parens)\">Foo*bar]</a></p>");
    return sb.toString();
  }
}
