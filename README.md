`Markdowikitext` is a project to test the `mylyn-wikitext.markdown` converter provided by the [Mylyn Wikitext](http://wiki.eclipse.org/Mylyn/WikiText) engine (part of the [Mylyn Docs](http://wiki.eclipse.org/Mylyn/Docs) project, an open-source project hosted by the [eclipse foundation](http://www.eclipse.org/org/)).


Description / usage
===================

markdowikitext.commonmark 
-------------------------

I have transformed the [CommonMark Spec](http://spec.commonmark.org/) into a JUnit test case: `CommonMarkTestBase`.
The class is abstract, because the idea is to plug several conversion engines.
The test class is near to the tests contained in the `mylyn-wikiktext` project, see [MarkdownLanguageTest](http://git.eclipse.org/c/mylyn/org.eclipse.mylyn.docs.git/tree/org.eclipse.mylyn.wikitext.markdown.tests/src/org/eclipse/mylyn/internal/wikitext/markdown/tests/MarkdownLanguageTest.java) for example.

I have chosen not to compare directly the HTML output, but to match it against a regular expression (in order to ignore whitespace near the HTML tags, line breaks and so on). 
This should provide a little bit more flexibility. 
If you think that the expressions should be improved, feel free to tell how. 

One of the converters that can be plug-in is a dummy implementation: `RefSpecParser`.
It just returns the HTML output defined in the specification.
The `RefSpecTest` class ensures that the regular expressions defined in the test suite are working with the output defined in the specification.
It is one way to ensure the quality of the test suite.

markdowikitext.commonmark.generator
-----------------------------------

The code I have used to generate `markdowikitext.commonmark`.
This is written with [Xtend](http://www.eclipse.org/xtend).

To open and compile it you will need:

* An IDE supporting the Xtend language
* Additional jars as dependencies (check the `libs` folder and replace the txt placeholder with the real jars)

The main class is: `markdowikitext.commonmark.generator.Main`. Run it as simple java application.


Issue tracker / Get in touch
============================

For this project:

* Use the [Markdowikitext issue tracker](http://github.com/jmini/markdowikitext/issues) on GitHub.

For the `mylyn-wikitext.markdown` converter itself:

* Mailing list: [mylyn-docs-dev](http://dev.eclipse.org/mhonarc/lists/mylyn-docs-dev/)
* Forum: [Mylyn](http://www.eclipse.org/forums/index.php/f/83/)
* StackOverflow Tag: [mylyn-wikitext](http://stackoverflow.com/tags/mylyn-wikitext)

License
=======

[Eclipse Public License - v 1.0](http://www.eclipse.org/legal/epl-v10.html)





