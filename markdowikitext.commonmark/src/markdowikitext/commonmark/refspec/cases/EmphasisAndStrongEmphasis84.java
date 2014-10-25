package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis84 extends RefSpecCase {

  public EmphasisAndStrongEmphasis84() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("*foo *bar**");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("**foo* bar*");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><em>foo <em>bar</em></em></p>");
    sb.append(BR);
    sb.append("<p><em><em>foo</em> bar</em></p>");
    return sb.toString();
  }
}