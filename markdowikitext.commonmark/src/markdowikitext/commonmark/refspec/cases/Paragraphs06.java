package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Paragraphs06 extends RefSpecCase {

  public Paragraphs06() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("   aaa");
    sb.append(BR);
    sb.append("bbb");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>aaa");
    sb.append(BR);
    sb.append("bbb</p>");
    return sb.toString();
  }
}