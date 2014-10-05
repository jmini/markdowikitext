package markdowikitext.commonmark.refspec.cases;

import markdowikitext.commonmark.refspec.RefSpecCase;

public class HtmlBlocks07 extends RefSpecCase {

  public HtmlBlocks07() {
    super(createInput(), createOutput());
  }

  public static String createInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<![CDATA[");
    sb.append(BR);
    sb.append("function matchwo(a,b)");
    sb.append(BR);
    sb.append("{");
    sb.append(BR);
    sb.append("if (a < b && a < 0) then");
    sb.append(BR);
    sb.append("  {");
    sb.append(BR);
    sb.append("  return 1;");
    sb.append(BR);
    sb.append("  }");
    sb.append(BR);
    sb.append("else");
    sb.append(BR);
    sb.append("  {");
    sb.append(BR);
    sb.append("  return 0;");
    sb.append(BR);
    sb.append("  }");
    sb.append(BR);
    sb.append("}");
    sb.append(BR);
    sb.append("]]>");
    return sb.toString();
  }

  public static String createOutput() {
    StringBuilder sb = new StringBuilder();
    sb.append("<![CDATA[");
    sb.append(BR);
    sb.append("function matchwo(a,b)");
    sb.append(BR);
    sb.append("{");
    sb.append(BR);
    sb.append("if (a < b && a < 0) then");
    sb.append(BR);
    sb.append("  {");
    sb.append(BR);
    sb.append("  return 1;");
    sb.append(BR);
    sb.append("  }");
    sb.append(BR);
    sb.append("else");
    sb.append(BR);
    sb.append("  {");
    sb.append(BR);
    sb.append("  return 0;");
    sb.append(BR);
    sb.append("  }");
    sb.append(BR);
    sb.append("}");
    sb.append(BR);
    sb.append("]]>");
    return sb.toString();
  }
}
