package markdowikitext.commonmark.refspec;

import markdowikitext.commonmark.CommonMarkTestBase;
import markdowikitext.commonmark.IMarkdownParser;

/**
 * @author jbr
 */
public class RefSpecTest extends CommonMarkTestBase {

  @Override
  protected IMarkdownParser initParser() {
    return new RefSpecParser();
  }
}
