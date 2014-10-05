package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class EmphasisAndStrongEmphasis35 extends RefSpecCase {

  public EmphasisAndStrongEmphasis35() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("__this is a double underscore (`__`)__");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><strong>this is a double underscore (<code>__</code>)</strong></p>");
    return sb.toString();
  }
}
