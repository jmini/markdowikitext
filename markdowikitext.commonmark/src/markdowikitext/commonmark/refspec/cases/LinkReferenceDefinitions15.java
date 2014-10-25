package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class LinkReferenceDefinitions15 extends RefSpecCase {

  public LinkReferenceDefinitions15() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("Foo");
    sb.append(BR);
    sb.append("[bar]: /baz");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("[bar]");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>Foo");
    sb.append(BR);
    sb.append("[bar]: /baz</p>");
    sb.append(BR);
    sb.append("<p>[bar]</p>");
    return sb.toString();
  }
}