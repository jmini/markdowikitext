package markdowikitext.commonmark.generator.converter

import static extension markdowikitext.commonmark.generator.converter.JavaUtil.*

import markdowikitext.commonmark.generator.cases.SpecCase
import org.jboss.forge.roaster.model.source.JavaClassSource
import org.jboss.forge.roaster.Roaster
import java.util.List
import markdowikitext.commonmark.generator.Param
import java.util.Arrays

class RefSpecCaseGenerator {
	val public static String PACKAGE = "markdowikitext.commonmark.refspec.cases"
	val static String INPUT = "createInput"
	val static String OUTPUT = "createOutput"
	
	def static toCaseFile(SpecCase c, Param param) {
		val JavaClassSource javaClass = Roaster::create(typeof(JavaClassSource))
	    javaClass.setPackage(PACKAGE)
		javaClass.addImport("markdowikitext.commonmark.refspec.RefSpecCase")
	    javaClass.setName(c.className)
	    javaClass.setSuperType("RefSpecCase")
	    javaClass.addPublicConstructor.setBody("super("+INPUT+"(), "+OUTPUT+"());")
	    javaClass.addCreate(INPUT, c.defLines)
	    javaClass.addCreate(OUTPUT, c.resultLines)
	    
		javaClass.toFile(param)
	}
	
	def private static addPublicConstructor(JavaClassSource javaClass) {
		javaClass.addMethod.setConstructor(true).setPublic
	}
	
	def private static addCreate(JavaClassSource javaClass, String name, List<String> lines) {
		javaClass.addMethod.setPublic.setStatic(true).setName(name).setReturnType("String").setBody('''
		    «JavaUtil::toStringBuilder(lines.map[it.replaceAll("→", "\t")], "sb", "BR")»
		    return sb.toString();
	    ''')
	}
	def private static addCreateOutput(JavaClassSource javaClass) {
		javaClass.addMethod.setPublic.setStatic(true).setName(OUTPUT).setReturnType("String")
	}
	
	def static toAllCaseFile(List<SpecCase> c, Param param) {
		val JavaClassSource javaClass = Roaster::create(typeof(JavaClassSource))
		javaClass.setPackage(PACKAGE)
		javaClass.addImport("markdowikitext.commonmark.refspec.RefSpecCase")
		javaClass.addImport(typeof(List))
		javaClass.addImport(typeof(Arrays))
		javaClass.setName("AllCases")
		javaClass.addMethod.setPublic
			.setStatic(true)
			.setName("list")
			.setReturnType("List<RefSpecCase>").setBody('''
				return Arrays.asList(
					«c.map["new " + it.className + "()"].join(",\n")»
				);
		''')
		javaClass.toFile(param)
	}
	
	
	
}