package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis83 extends RefSpecCase {

  public EmphasisAndStrongEmphasis83() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("*foo**");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("**foo*");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><em>foo</em>*</p>");
    sb.append(BR);
    sb.append("<p>*<em>foo</em></p>");
    return sb.toString();
  }
}