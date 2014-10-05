package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class SetextHeaders07 extends RefSpecCase {

  public SetextHeaders07() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("Foo");
    sb.append(BR);
    sb.append("= =");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("Foo");
    sb.append(BR);
    sb.append("--- -");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>Foo");
    sb.append(BR);
    sb.append("= =</p>");
    sb.append(BR);
    sb.append("<p>Foo</p>");
    sb.append(BR);
    sb.append("<hr />");
    return sb.toString();
  }
}
