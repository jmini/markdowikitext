package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis58 extends RefSpecCase {

  public EmphasisAndStrongEmphasis58() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("**foo **bar** baz**");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><strong>foo <strong>bar</strong> baz</strong></p>");
    return sb.toString();
  }
}
