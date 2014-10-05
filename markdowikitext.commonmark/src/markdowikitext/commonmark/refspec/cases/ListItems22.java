package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems22 extends RefSpecCase {

  public ListItems22() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("    1.  A paragraph");
    sb.append(BR);
    sb.append("        with two lines.");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("            indented code");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("        > A block quote.");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<pre><code>1.  A paragraph");
    sb.append(BR);
    sb.append("    with two lines.");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("        indented code");
    sb.append(BR);
    sb.append("");
    sb.append(BR);
    sb.append("    &gt; A block quote.");
    sb.append(BR);
    sb.append("</code></pre>");
    return sb.toString();
  }
}
