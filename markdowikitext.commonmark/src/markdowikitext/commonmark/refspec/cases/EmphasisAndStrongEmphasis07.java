package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis07 extends RefSpecCase {

  public EmphasisAndStrongEmphasis07() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("**foo");
    sb.append(BR);
    sb.append("bar**");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><strong>foo");
    sb.append(BR);
    sb.append("bar</strong></p>");
    return sb.toString();
  }
}