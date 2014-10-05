package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis19 extends RefSpecCase {

  public EmphasisAndStrongEmphasis19() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("**a<http://foo.bar?q=**>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>**a<a href=\"http://foo.bar?q=**\">http://foo.bar?q=**</a></p>");
    return sb.toString();
  }
}
