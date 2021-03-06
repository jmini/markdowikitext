package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis59 extends RefSpecCase {

  public EmphasisAndStrongEmphasis59() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("_foo __bar___");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><em>foo <strong>bar</strong></em></p>");
    return sb.toString();
  }
}