package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions17 extends RefSpecCase {

  public LinkReferenceDefinitions17() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo]: /foo-url \"foo\"");
    sb.append(BR);
    sb.append("[bar]: /bar-url");
    sb.append(BR);
    sb.append("  \"bar\"");
    sb.append(BR);
    sb.append("[baz]: /baz-url");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo],");
    sb.append(BR);
    sb.append("[bar],");
    sb.append(BR);
    sb.append("[baz]");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/foo-url\" title=\"foo\">foo</a>,");
    sb.append(BR);
    sb.append("<a href=\"/bar-url\" title=\"bar\">bar</a>,");
    sb.append(BR);
    sb.append("<a href=\"/baz-url\">baz</a></p>");
    return sb.toString();
  }
}