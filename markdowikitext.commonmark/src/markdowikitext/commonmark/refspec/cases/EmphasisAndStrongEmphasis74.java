package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis74 extends RefSpecCase {

  public EmphasisAndStrongEmphasis74() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("*foo****");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>*foo****</p>");
    return sb.toString();
  }
}
