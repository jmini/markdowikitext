package markdowikitext.commonmark.generator.converter

import static extension markdowikitext.commonmark.generator.converter.JavaUtil.*

import java.util.List
import markdowikitext.commonmark.generator.cases.SpecCase
import markdowikitext.commonmark.generator.Param
import org.jboss.forge.roaster.model.source.JavaClassSource
import org.jboss.forge.roaster.Roaster
import java.util.regex.Pattern
import com.google.common.base.CharMatcher

class CommonMarkGenerator {
	def static toTestFile(List<SpecCase> c, Param param) {
		val JavaClassSource javaClass = Roaster::create(typeof(JavaClassSource))
		javaClass.setAbstract(true)
		javaClass.setPackage("markdowikitext.commonmark")
		javaClass.addImport("junit.framework.TestCase")
		javaClass.addImport(typeof(Pattern))
		javaClass.setName("CommonMarkTestBase")
		javaClass.setSuperType("TestCase")
		
		javaClass.addField('private static final String BR = System.getProperty("line.separator")')
		javaClass.addField('private IMarkdownParser parser')
		
		javaClass.addMethod.setProtected.setName("setUp").addThrows(typeof(Exception)).setBody("parser = initParser();").addAnnotation(typeof(Override))
		
		javaClass.addMethod.setProtected.setName("initParser").setAbstract(true).setReturnType("IMarkdownParser")
		
		c.forEach[
			javaClass.addMethod.setPublic.setName("test" + it.className).addThrows(typeof(Exception)).setBody('''
				«JavaUtil::toStringBuilder(it.defLines.map[it.replaceAll("→", "\t")], "text", "BR")»
				
				String html = parser.toHtml(text.toString());
				TestUtil.println("HTML: " + html);
				
				«JavaUtil::toStringBuilder(it.resultLines.map[
					var s = it
					s = CharMatcher::is('→').replaceFrom(s, "\t")
					s = CharMatcher::is('\\').replaceFrom(s, "\\\\")
					s = CharMatcher::is('*').replaceFrom(s, "\\*")
					s = CharMatcher::is('[').replaceFrom(s, "\\[")
					s = CharMatcher::is(']').replaceFrom(s, "\\]")
					s = CharMatcher::is('(').replaceFrom(s, "\\(")
					s = CharMatcher::is(')').replaceFrom(s, "\\)")
					s = CharMatcher::is('{').replaceFrom(s, "\\{")
					s = CharMatcher::is('}').replaceFrom(s, "\\}")
					s = CharMatcher::is('$').replaceFrom(s, "\\$")
					s = CharMatcher::is('?').replaceFrom(s, "\\?")
					s = CharMatcher::is('+').replaceFrom(s, "\\+")
					s = CharMatcher::is('.').replaceFrom(s, "\\.")
					s = CharMatcher::is('`').replaceFrom(s, "\\`")
					s = CharMatcher::is('>').replaceFrom(s, ">\\s*")
					s = CharMatcher::is('<').replaceFrom(s, "\\s*<")
					s + "\\s*"
				], "sb")»
				assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
				    .matcher(html)
				    .find());
			''')
		]
		javaClass.toFile(param)
		
	}
}