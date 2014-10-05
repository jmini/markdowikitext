package markdowikitext.commonmark.refspec;

import java.util.List;

import markdowikitext.commonmark.IMarkdownParser;
import markdowikitext.commonmark.refspec.cases.AllCases;

/**
 * @author jbr
 */
public class RefSpecParser implements IMarkdownParser {

  private final List<RefSpecCase> cases;

  public RefSpecParser() {
    cases = AllCases.list();
  }

  @Override
  public String toHtml(String markdown) {
    for (RefSpecCase c : cases) {
      if (markdown.equals(c.getInput())) {
        return c.getOutput();
      }
    }
    throw new IllegalStateException("Missing case: " + markdown);
  }
}
