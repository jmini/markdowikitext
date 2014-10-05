package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis20 extends RefSpecCase {

  public EmphasisAndStrongEmphasis20() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("__a<http://foo.bar?q=__>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>__a<a href=\"http://foo.bar?q=__\">http://foo.bar?q=__</a></p>");
    return sb.toString();
  }
}
