package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class SetextHeaders01 extends RefSpecCase {

  public SetextHeaders01() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("Foo *bar*");
    sb.append(BR);
    sb.append("=========");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("Foo *bar*");
    sb.append(BR);
    sb.append("---------");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h1>Foo <em>bar</em></h1>");
    sb.append(BR);
    sb.append("<h2>Foo <em>bar</em></h2>");
    return sb.toString();
  }
}
