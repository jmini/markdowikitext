package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class IndentedCodeBlocks05 extends RefSpecCase {

  public IndentedCodeBlocks05() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("Foo");
    sb.append(BR);
    sb.append("    bar");
    sb.append(BR);
    sb.append("");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>Foo");
    sb.append(BR);
    sb.append("bar</p>");
    return sb.toString();
  }
}