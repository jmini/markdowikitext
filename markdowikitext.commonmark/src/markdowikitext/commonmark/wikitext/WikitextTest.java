package markdowikitext.commonmark.wikitext;

import markdowikitext.commonmark.CommonMarkTestBase;
import markdowikitext.commonmark.IMarkdownParser;

/**
 * @author jbr
 */
public class WikitextTest extends CommonMarkTestBase {

  @Override
  protected IMarkdownParser initParser() {
    return new WikitextParser();
  }
}
