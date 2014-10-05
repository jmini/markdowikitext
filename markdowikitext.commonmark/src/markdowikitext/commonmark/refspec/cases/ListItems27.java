package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class ListItems27 extends RefSpecCase {

  public ListItems27() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("- foo");
    sb.append(BR);
    sb.append("  - bar");
    sb.append(BR);
    sb.append("    - baz");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>foo");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>bar");
    sb.append(BR);
    sb.append("<ul>");
    sb.append(BR);
    sb.append("<li>baz</li>");
    sb.append(BR);
    sb.append("</ul></li>");
    sb.append(BR);
    sb.append("</ul></li>");
    sb.append(BR);
    sb.append("</ul>");
    return sb.toString();
  }
}
