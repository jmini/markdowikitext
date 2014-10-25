package markdowikitext.commonmark.generator

import markdowikitext.commonmark.generator.converter.JavaUtil
import markdowikitext.commonmark.generator.converter.CommonMarkGenerator
import markdowikitext.commonmark.generator.converter.RefSpecCaseGenerator
import markdowikitext.commonmark.generator.reader.SpecReader
import markdowikitext.commonmark.generator.cases.Spec
import markdowikitext.commonmark.generator.cases.SpecCase

class Main {
	
	val static Param param = new Param
	
	def static void main(String[] args) {
		val spec = SpecReader::readFile(param)
//		val spec = new markdowikitext.commonmark.generator.cases.SpecExample()

//		spec.printSpec()
//		spec.printJavaSpec()
//		spec.printJavaSpec("Autolinks1")
//		spec.printSpecTitle()

		spec.create(param)
	}
	
	def static create(Spec spec, Param param) {
		val cases = spec.cases;
		
		//RefSpec - one file for each case:
		val folder = JavaUtil::toFolder(RefSpecCaseGenerator::PACKAGE, param)
		folder.listFiles.filter[it.name.endsWith("java")].forEach[it.delete]
		cases.forEach[
			RefSpecCaseGenerator::toCaseFile(it, param)
		]
		
		//RefSpec - AllCases class:
		RefSpecCaseGenerator::toAllCaseFile(cases, param)
		
		//Test suite - CommonMarkTestBase class:
		CommonMarkGenerator::toTestFile(cases, param)
	}
	
	def static void printSpec(Spec spec) {
		println(spec.cases.size)
		spec.cases.forEach[
			println(">>> " +it.getClassName + " input")
			it.defLines.forEach[
				println(it)
			]
			println(">>> " +it.getClassName + " output")
			it.resultLines.forEach[
				println(it)
			]
		]
	}
	
	def static void printSpecTitle(Spec spec) {
		spec.cases.forEach[
			println(it.getClassName)
		]
	}
	
	def static void printJavaSpec(Spec spec) {
		println(spec.cases.size)
		spec.cases.forEach[
			it.printJavaSpec()
		]
	}
	
	def static void printJavaSpec(Spec spec, String name) {
		println(spec.cases.size)
		spec.cases.filter[
			it.title == name
		].forEach[
			it.printJavaSpec()
		]
	}
	
	def static printJavaSpec(SpecCase c) {
		println(">>> " +c.getClassName + " input")
		println(JavaUtil::toStringBuilder(c.defLines.map[it.replaceAll("→", "\t")], "sb", "BR"))
		println(">>> " +c.getClassName + " output")
		println(JavaUtil::toStringBuilder(c.resultLines.map[it.replaceAll("→", "\t")], "sb", "BR"))	}
	
}