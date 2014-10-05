package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class BackslashEscapes03 extends RefSpecCase {

  public BackslashEscapes03() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("\\*not emphasized*");
    sb.append(BR);
    sb.append("\\<br/> not a tag");
    sb.append(BR);
    sb.append("\\[not a link](/foo)");
    sb.append(BR);
    sb.append("\\`not code`");
    sb.append(BR);
    sb.append("1\\. not a list");
    sb.append(BR);
    sb.append("\\* not a list");
    sb.append(BR);
    sb.append("\\# not a header");
    sb.append(BR);
    sb.append("\\[foo]: /url \"not a reference\"");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<p>*not emphasized*");
    sb.append(BR);
    sb.append("&lt;br/&gt; not a tag");
    sb.append(BR);
    sb.append("[not a link](/foo)");
    sb.append(BR);
    sb.append("`not code`");
    sb.append(BR);
    sb.append("1. not a list");
    sb.append(BR);
    sb.append("* not a list");
    sb.append(BR);
    sb.append("# not a header");
    sb.append(BR);
    sb.append("[foo]: /url &quot;not a reference&quot;</p>");
    return sb.toString();
  }
}
