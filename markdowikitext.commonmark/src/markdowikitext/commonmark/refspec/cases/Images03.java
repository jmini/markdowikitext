package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Images03 extends RefSpecCase {

  public Images03() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("![foo *bar*][]");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo *bar*]: train.jpg \"train & tracks\"");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><img src=\"train.jpg\" alt=\"foo &lt;em&gt;bar&lt;/em&gt;\" title=\"train &amp; tracks\" /></p>");
    return sb.toString();
  }
}