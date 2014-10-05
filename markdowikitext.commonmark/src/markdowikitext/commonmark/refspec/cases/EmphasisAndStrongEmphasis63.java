package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis63 extends RefSpecCase {

  public EmphasisAndStrongEmphasis63() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("__foo _bar_ baz__");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><strong>foo <em>bar</em> baz</strong></p>");
    return sb.toString();
  }
}
