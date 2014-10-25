package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HtmlBlocks04 extends RefSpecCase {

  public HtmlBlocks04() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<div></div>");
    sb.append(BR);
    sb.append("``` c");
    sb.append(BR);
    sb.append("int x = 33;");
    sb.append(BR);
    sb.append("```");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<div></div>");
    sb.append(BR);
    sb.append("``` c");
    sb.append(BR);
    sb.append("int x = 33;");
    sb.append(BR);
    sb.append("```");
    return sb.toString();
  }
}