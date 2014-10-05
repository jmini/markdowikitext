package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class AtxHeaders14 extends RefSpecCase {

  public AtxHeaders14() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("### foo \\###");
    sb.append(BR);
    sb.append("## foo \\#\\##");
    sb.append(BR);
    sb.append("# foo \\#");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h3>foo #</h3>");
    sb.append(BR);
    sb.append("<h2>foo ##</h2>");
    sb.append(BR);
    sb.append("<h1>foo #</h1>");
    return sb.toString();
  }
}
