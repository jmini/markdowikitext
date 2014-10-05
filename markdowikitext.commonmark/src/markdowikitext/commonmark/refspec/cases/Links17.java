package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Links17 extends RefSpecCase {

  public Links17() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("[link](/url \"title \"and\" title\")");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>[link](/url &quot;title &quot;and&quot; title&quot;)</p>");
    return sb.toString();
  }
}
