package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Images04 extends RefSpecCase {

  public Images04() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("![foo *bar*][foobar]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[FOOBAR]: train.jpg \"train & tracks\"");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><img src=\"train.jpg\" alt=\"foo &lt;em&gt;bar&lt;/em&gt;\" title=\"train &amp; tracks\" /></p>");
    return sb.toString();
  }
}