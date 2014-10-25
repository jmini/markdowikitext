package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis94 extends RefSpecCase {

  public EmphasisAndStrongEmphasis94() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("*<img src=\"foo\" title=\"*\"/>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>*<img src=\"foo\" title=\"*\"/></p>");
    return sb.toString();
  }
}