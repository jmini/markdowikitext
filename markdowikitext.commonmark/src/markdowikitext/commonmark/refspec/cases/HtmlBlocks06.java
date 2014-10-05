package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HtmlBlocks06 extends RefSpecCase {

  public HtmlBlocks06() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<?php");
    sb.append(BR);
    sb.append("  echo 'foo'");
    sb.append(BR);
    sb.append("?>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<?php");
    sb.append(BR);
    sb.append("  echo 'foo'");
    sb.append(BR);
    sb.append("?>");
    return sb.toString();
  }
}
