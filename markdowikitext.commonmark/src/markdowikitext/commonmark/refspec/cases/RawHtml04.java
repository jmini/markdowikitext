package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class RawHtml04 extends RefSpecCase {

  public RawHtml04() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<a foo=\"bar\" bam = 'baz <em>\"</em>'");
    sb.append(BR);
    sb.append("_boolean zoop:33=zoop:33 />");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a foo=\"bar\" bam = 'baz <em>\"</em>'");
    sb.append(BR);
    sb.append("_boolean zoop:33=zoop:33 /></p>");
    return sb.toString();
  }
}
