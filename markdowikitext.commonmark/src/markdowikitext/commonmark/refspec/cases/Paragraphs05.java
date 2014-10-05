package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Paragraphs05 extends RefSpecCase {

  public Paragraphs05() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("aaa");
    sb.append(BR);
    sb.append("             bbb");
    sb.append(BR);
    sb.append("                                       ccc");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>aaa");
    sb.append(BR);
    sb.append("bbb");
    sb.append(BR);
    sb.append("ccc</p>");
    return sb.toString();
  }
}
