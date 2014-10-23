package markdowikitext.commonmark.generator.converter

import markdowikitext.commonmark.generator.cases.SpecCase
import java.util.List
import org.jboss.forge.roaster.model.source.JavaClassSource
import markdowikitext.commonmark.generator.Param
import com.google.common.base.Charsets
import java.io.File
import com.google.common.io.Files
import com.google.common.base.CharMatcher

class JavaUtil {
	def static toClassName(SpecCase c) {
		c.title
	}
	
	def static String toStringBuilder(List<String> lines, String name, String lineBreak) '''
	«var first = true»
	StringBuilder «name» = new StringBuilder();
	«FOR l : lines»
	«IF first»«{first = false; null}»«ELSE»«name».append(«lineBreak»);«ENDIF»
	«name».append(«l.toJavaString»);
	«ENDFOR»
	'''
	
	def static String toStringBuilder(List<String> lines, String name) '''
	StringBuilder «name» = new StringBuilder();
	«FOR l : lines»
	«name».append(«l.toJavaString»);
	«ENDFOR»
	'''
		
	def static String toJavaString(String input) {
		var s = input
		s = CharMatcher::anyOf('\\').replaceFrom(s, '\\\\')
		s = s.replaceAll("\"","\\\\\"")
		s = s.replaceAll("\t", '\\\\t')
		s = s.replaceAll("\n", '\\\\n')
		return '"' + s + '"'
	}
	
		
	def static toFile(JavaClassSource javaClass, Param param) {
		val folder = toFolder(javaClass.package, param)
		val file = new File(folder, javaClass.name + ".java")
		
		Files::createParentDirs(file)
		Files::write(javaClass.toString, file, Charsets::UTF_8)
		println ("write: " + file.absolutePath)
	}
	
	def static toFolder(String javaClassPackage, Param param) {
		val parts = javaClassPackage.split("\\.")
		val File srcFolder = new File(param.commonmarkPath);
		return parts.fold(srcFolder, [File parent, String childName | new File(parent, childName)])
	}
}