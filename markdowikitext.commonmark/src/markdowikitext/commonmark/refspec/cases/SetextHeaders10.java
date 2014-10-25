package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class SetextHeaders10 extends RefSpecCase {

  public SetextHeaders10() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("`Foo");
    sb.append(BR);
    sb.append("----");
    sb.append(BR);
    sb.append("`");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("<a title=\"a lot");
    sb.append(BR);
    sb.append("---");
    sb.append(BR);
    sb.append("of dashes\"/>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h2>`Foo</h2>");
    sb.append(BR);
    sb.append("<p>`</p>");
    sb.append(BR);
    sb.append("<h2>&lt;a title=&quot;a lot</h2>");
    sb.append(BR);
    sb.append("<p>of dashes&quot;/&gt;</p>");
    return sb.toString();
  }
}