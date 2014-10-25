package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis93 extends RefSpecCase {

  public EmphasisAndStrongEmphasis93() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("*![foo*](bar)");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>*<img src=\"bar\" alt=\"foo*\" /></p>");
    return sb.toString();
  }
}