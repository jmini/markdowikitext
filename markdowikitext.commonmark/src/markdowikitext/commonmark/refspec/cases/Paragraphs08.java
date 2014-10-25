package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Paragraphs08 extends RefSpecCase {

  public Paragraphs08() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("aaa     ");
    sb.append(BR);
    sb.append("bbb     ");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>aaa<br />");
    sb.append(BR);
    sb.append("bbb</p>");
    return sb.toString();
  }
}