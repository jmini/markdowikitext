package markdowikitext.commonmark;

/**
 * @author jbr
 */
public interface IMarkdownParser {
  /**
   * Conversion method from markdown to html
   *
   * @param markdown
   *          input
   * @return html output
   */
  String toHtml(String markdown);
}
