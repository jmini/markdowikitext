package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class Autolinks02 extends RefSpecCase {

  public Autolinks02() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<http://foo.bar.baz?q=hello&id=22&boolean>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><a href=\"http://foo.bar.baz?q=hello&amp;id=22&amp;boolean\">http://foo.bar.baz?q=hello&amp;id=22&amp;boolean</a></p>");
    return sb.toString();
  }
}
