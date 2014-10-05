package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis33 extends RefSpecCase {

  public EmphasisAndStrongEmphasis33() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("**** is not an empty strong emphasis");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>**** is not an empty strong emphasis</p>");
    return sb.toString();
  }
}
