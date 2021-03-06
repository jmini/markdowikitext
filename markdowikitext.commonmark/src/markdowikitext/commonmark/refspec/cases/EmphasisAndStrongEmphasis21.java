package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis21 extends RefSpecCase {

  public EmphasisAndStrongEmphasis21() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("and * foo bar*");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>and * foo bar*</p>");
    return sb.toString();
  }
}