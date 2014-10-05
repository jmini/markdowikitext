package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions08 extends RefSpecCase {

  public LinkReferenceDefinitions08() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo]: first");
    sb.append(BR);
    sb.append("[foo]: second");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"first\">foo</a></p>");
    return sb.toString();
  }
}
