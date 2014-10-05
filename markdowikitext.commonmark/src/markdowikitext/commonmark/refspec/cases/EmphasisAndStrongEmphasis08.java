package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis08 extends RefSpecCase {

  public EmphasisAndStrongEmphasis08() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("__foo");
    sb.append(BR);
    sb.append("bar__");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><strong>foo");
    sb.append(BR);
    sb.append("bar</strong></p>");
    return sb.toString();
  }
}
