package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions14 extends RefSpecCase {

  public LinkReferenceDefinitions14() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("```");
    sb.append(BR);
    sb.append("[foo]: /url");
    sb.append(BR);
    sb.append("```");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[foo]");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>[foo]: /url");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("<p>[foo]</p>");
    return sb.toString();
  }
}
