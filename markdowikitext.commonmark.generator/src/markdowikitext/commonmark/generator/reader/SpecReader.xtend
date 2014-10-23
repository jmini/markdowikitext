package markdowikitext.commonmark.generator.reader

import markdowikitext.commonmark.generator.Param
import com.google.common.io.Files
import com.google.common.base.Charsets
import java.io.File
import markdowikitext.commonmark.generator.cases.SpecCase
import com.google.common.base.CharMatcher
import markdowikitext.commonmark.generator.cases.Spec
import com.google.common.io.Resources
import java.net.URL

class SpecReader {
		def static readFile(Param param) {
			
			val lines = if(param.specPath != null) {
				val file = new File(param.specPath)
				Files::readLines(file, Charsets::UTF_8)
			} else {
				val url = new URL(param.specUrl);
				Resources::readLines(url, Charsets::UTF_8)
			}
			val result = new Spec
			var String lastTitle
			var boolean defStarted = false
			var boolean resultStarted = false
			var SpecCase c;
			for (l :lines) {
				if(l.startsWith("#") && c == null) {
					lastTitle = CharMatcher::anyOf("#").removeFrom(l).trim
					lastTitle = lastTitle + "#"
				} else if(l == ".") {
					if(defStarted) {
						defStarted = false;
						resultStarted = true;
					} else if(resultStarted) {
						resultStarted = false;
						c = null;
					} else {
						defStarted = true;
						c = new SpecCase
						result.addCase(c)
						c.title = CharMatcher::anyOf("#").removeFrom(lastTitle).trim + CharMatcher::anyOf("#").retainFrom(lastTitle).length.formatInt
						lastTitle = lastTitle + "#"
					}
				} else if(c != null) {
					if(defStarted) {
						c.addDefLine(l)
					} 
					if(resultStarted) {
						c.addResultLine(l)
					} 
				}
			} 
			return result
		}
		
		def static formatInt(int i) {
			val s = String::valueOf(i)
			if (s.length == 1) {
				return "0" + s
			}
			return s
		}
		
}