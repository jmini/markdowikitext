package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis06 extends RefSpecCase {

  public EmphasisAndStrongEmphasis06() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("_foo");
    sb.append(BR);
    sb.append("bar_");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><em>foo");
    sb.append(BR);
    sb.append("bar</em></p>");
    return sb.toString();
  }
}
