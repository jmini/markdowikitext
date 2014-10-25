package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions10 extends RefSpecCase {

  public LinkReferenceDefinitions10() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ΑΓΩ]: /φου");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[αγω]");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"/%CF%86%CE%BF%CF%85\">αγω</a></p>");
    return sb.toString();
  }
}