package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis13 extends RefSpecCase {

  public EmphasisAndStrongEmphasis13() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("*foo [bar*](/url)");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>*foo <a href=\"/url\">bar*</a></p>");
    return sb.toString();
  }
}
