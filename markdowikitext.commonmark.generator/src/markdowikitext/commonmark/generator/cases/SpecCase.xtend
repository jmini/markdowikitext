package markdowikitext.commonmark.generator.cases

import java.util.List
import java.util.ArrayList
import com.google.common.base.CaseFormat

class SpecCase {
	@Property String title
	@Property List<String> defLines
	@Property List<String> resultLines
	
	new() {
		this.defLines = new ArrayList
		this.resultLines = new ArrayList
	}
	
	def getClassName() {
		val s = title.replaceAll(" ", "_").toUpperCase
		return CaseFormat::UPPER_UNDERSCORE.to(CaseFormat::UPPER_CAMEL, s)
	}
	
	def addDefLine(String l) {
		this.defLines.add(l)
	}
	
	def addResultLine(String l) {
		this.resultLines.add(l)
	}
	
}

class Spec {
	
	new() {
		this.cases = new ArrayList
	}
	
	@Property List<SpecCase> cases
	
    def addCase(SpecCase c) {
    	cases.add(c)
    }
}

class SpecExample extends Spec {
	
	new() {
		super()
		addCase(new SpecCase => [
			title = "Preprocessing"
			defLines = #["→foo→baz→→bim"]
			resultLines = #["<pre><code>foo baz     bim", "</code></pre>"]
		])
		addCase(new SpecCase => [
			title = "Precedence"
			defLines = #["- `one", "- two`"]
			resultLines = #["<ul>", "<li>`one</li>", "<li>two`</li>", "</ul>"]
		])
	}
}