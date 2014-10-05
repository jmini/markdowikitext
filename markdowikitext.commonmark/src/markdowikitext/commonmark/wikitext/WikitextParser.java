package markdowikitext.commonmark.wikitext;

import java.io.StringWriter;

import markdowikitext.commonmark.IMarkdownParser;

import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.core.parser.builder.HtmlDocumentBuilder;
import org.eclipse.mylyn.wikitext.core.parser.markup.MarkupLanguage;
import org.eclipse.mylyn.wikitext.core.util.ServiceLocator;

/**
 * @author jbr
 */
public class WikitextParser implements IMarkdownParser {

  @Override
  public String toHtml(String input) {
    MarkupLanguage markupLanguage = ServiceLocator.getInstance().getMarkupLanguage("Markdown");

    MarkupParser markupParser = new MarkupParser();
    markupParser.setMarkupLanguage(markupLanguage);

    StringWriter out = new StringWriter();
    HtmlDocumentBuilder documentBuilder = new HtmlDocumentBuilder(out);
    documentBuilder.setEmitAsDocument(false);
    markupParser.setBuilder(documentBuilder);

    markupParser.parse(input);

    return out.toString();
  }

}
