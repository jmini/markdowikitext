package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HorizontalRules19 extends RefSpecCase {

  public HorizontalRules19() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- Foo");
    sb.append(BR);
    sb.append("- * * *");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>Foo</li>");
    sb.append(BR);
    sb.append("<li><hr /></li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}