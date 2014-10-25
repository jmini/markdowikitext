package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class IndentedCodeBlocks07 extends RefSpecCase {

  public IndentedCodeBlocks07() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("# Header");
    sb.append(BR);
    sb.append("    foo");
    sb.append(BR);
    sb.append("Header");
    sb.append(BR);
    sb.append("------");
    sb.append(BR);
    sb.append("    foo");
    sb.append(BR);
    sb.append("----");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<h1>Header</h1>");
    sb.append(BR);
    sb.append("<pre><code>foo");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("<h2>Header</h2>");
    sb.append(BR);
    sb.append("<pre><code>foo");
    sb.append(BR);
    sb.append("</code></pre>");
    sb.append(BR);
    sb.append("<hr />");
    return sb.toString();
  }
}