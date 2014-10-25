package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Paragraphs02 extends RefSpecCase {

  public Paragraphs02() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("aaa");
    sb.append(BR);
    sb.append("bbb");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("ccc");
    sb.append(BR);
    sb.append("ddd");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>aaa");
    sb.append(BR);
    sb.append("bbb</p>");
    sb.append(BR);
    sb.append("<p>ccc");
    sb.append(BR);
    sb.append("ddd</p>");
    return sb.toString();
  }
}