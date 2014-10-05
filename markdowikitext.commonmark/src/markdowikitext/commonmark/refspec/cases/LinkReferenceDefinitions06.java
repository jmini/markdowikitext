package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions06 extends RefSpecCase {

  public LinkReferenceDefinitions06() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[foo]:");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo]");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>[foo]:</p>");
    sb.append(BR);
    sb.append("<p>[foo]</p>");
    return sb.toString();
  }
}
