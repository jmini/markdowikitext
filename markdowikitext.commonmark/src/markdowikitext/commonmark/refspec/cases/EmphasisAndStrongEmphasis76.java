package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis76 extends RefSpecCase {

  public EmphasisAndStrongEmphasis76() {
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
    sb.append("<p>**foo* bar*</p>");
    return sb.toString();
  }
}
