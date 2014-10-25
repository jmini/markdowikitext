package markdowikitext.commonmark;

import junit.framework.TestCase;
import java.util.regex.Pattern;
import java.lang.Exception;
import java.lang.Override;

public abstract class CommonMarkTestBase extends TestCase {

  private static final String BR = System.getProperty("line.separator");
  private IMarkdownParser parser;

  @Override
  protected void setUp() throws Exception {
    parser = initParser();
  }

  protected abstract IMarkdownParser initParser();

  public void testPreprocessing01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("\tfoo\tbaz\t\tbim");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*foo baz     bim\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testPreprocessing02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    a\ta");
    text.append(BR);
    text.append("    ὐ\ta");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*a   a\\s*");
    sb.append("ὐ   a\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testPrecedence01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- `one");
    text.append(BR);
    text.append("- two`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\`one\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*two\\`\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("***");
    text.append(BR);
    text.append("---");
    text.append(BR);
    text.append("___");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<hr />\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("+++");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\+\\+\\+\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("===");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*===\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("--");
    text.append(BR);
    text.append("**");
    text.append(BR);
    text.append("__");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*--\\s*");
    sb.append("\\*\\*\\s*");
    sb.append("__\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(" ***");
    text.append(BR);
    text.append("  ***");
    text.append(BR);
    text.append("   ***");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<hr />\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    ***");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*\\*\\*\\*\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo");
    text.append(BR);
    text.append("    ***");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*Foo\\s*");
    sb.append("\\*\\*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_____________________________________");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(" - - -");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(" **  * ** * ** * **");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("-     -      -      -");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- - - -    ");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_ _ _ _ a");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("a------");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("---a---");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*_ _ _ _ a\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*a------\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*---a---\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(" *-*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*-\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules15() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- foo");
    text.append(BR);
    text.append("***");
    text.append(BR);
    text.append("- bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*bar\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules16() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo");
    text.append(BR);
    text.append("***");
    text.append(BR);
    text.append("bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*Foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules17() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo");
    text.append(BR);
    text.append("---");
    text.append(BR);
    text.append("bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h2>\\s*Foo\\s*</h2>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules18() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("* Foo");
    text.append(BR);
    text.append("* * *");
    text.append(BR);
    text.append("* Bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*Foo\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*Bar\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHorizontalRules19() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- Foo");
    text.append(BR);
    text.append("- * * *");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*Foo\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<hr />\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("# foo");
    text.append(BR);
    text.append("## foo");
    text.append(BR);
    text.append("### foo");
    text.append(BR);
    text.append("#### foo");
    text.append(BR);
    text.append("##### foo");
    text.append(BR);
    text.append("###### foo");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h1>\\s*foo\\s*</h1>\\s*\\s*");
    sb.append("\\s*<h2>\\s*foo\\s*</h2>\\s*\\s*");
    sb.append("\\s*<h3>\\s*foo\\s*</h3>\\s*\\s*");
    sb.append("\\s*<h4>\\s*foo\\s*</h4>\\s*\\s*");
    sb.append("\\s*<h5>\\s*foo\\s*</h5>\\s*\\s*");
    sb.append("\\s*<h6>\\s*foo\\s*</h6>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("####### foo");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*####### foo\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("#5 bolt");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*#5 bolt\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("\\## foo");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*## foo\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("# foo *bar* \\*baz\\*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h1>\\s*foo \\s*<em>\\s*bar\\s*</em>\\s* \\*baz\\*\\s*</h1>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("#                  foo                     ");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h1>\\s*foo\\s*</h1>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(" ### foo");
    text.append(BR);
    text.append("  ## foo");
    text.append(BR);
    text.append("   # foo");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h3>\\s*foo\\s*</h3>\\s*\\s*");
    sb.append("\\s*<h2>\\s*foo\\s*</h2>\\s*\\s*");
    sb.append("\\s*<h1>\\s*foo\\s*</h1>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    # foo");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*# foo\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo");
    text.append(BR);
    text.append("    # bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo\\s*");
    sb.append("# bar\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("## foo ##");
    text.append(BR);
    text.append("  ###   bar    ###");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h2>\\s*foo\\s*</h2>\\s*\\s*");
    sb.append("\\s*<h3>\\s*bar\\s*</h3>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("# foo ##################################");
    text.append(BR);
    text.append("##### foo ##");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h1>\\s*foo\\s*</h1>\\s*\\s*");
    sb.append("\\s*<h5>\\s*foo\\s*</h5>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("### foo ###     ");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h3>\\s*foo\\s*</h3>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("### foo ### b");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h3>\\s*foo ### b\\s*</h3>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("### foo \\###");
    text.append(BR);
    text.append("## foo \\#\\##");
    text.append(BR);
    text.append("# foo \\#");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h3>\\s*foo #\\s*</h3>\\s*\\s*");
    sb.append("\\s*<h2>\\s*foo ##\\s*</h2>\\s*\\s*");
    sb.append("\\s*<h1>\\s*foo #\\s*</h1>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders15() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("****");
    text.append(BR);
    text.append("## foo");
    text.append(BR);
    text.append("****");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<hr />\\s*\\s*");
    sb.append("\\s*<h2>\\s*foo\\s*</h2>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders16() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo bar");
    text.append(BR);
    text.append("# baz");
    text.append(BR);
    text.append("Bar foo");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*Foo bar\\s*</p>\\s*\\s*");
    sb.append("\\s*<h1>\\s*baz\\s*</h1>\\s*\\s*");
    sb.append("\\s*<p>\\s*Bar foo\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAtxHeaders17() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("## ");
    text.append(BR);
    text.append("#");
    text.append(BR);
    text.append("### ###");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h2>\\s*\\s*</h2>\\s*\\s*");
    sb.append("\\s*<h1>\\s*\\s*</h1>\\s*\\s*");
    sb.append("\\s*<h3>\\s*\\s*</h3>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo *bar*");
    text.append(BR);
    text.append("=========");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("Foo *bar*");
    text.append(BR);
    text.append("---------");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h1>\\s*Foo \\s*<em>\\s*bar\\s*</em>\\s*\\s*</h1>\\s*\\s*");
    sb.append("\\s*<h2>\\s*Foo \\s*<em>\\s*bar\\s*</em>\\s*\\s*</h2>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo");
    text.append(BR);
    text.append("-------------------------");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("Foo");
    text.append(BR);
    text.append("=");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h2>\\s*Foo\\s*</h2>\\s*\\s*");
    sb.append("\\s*<h1>\\s*Foo\\s*</h1>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("   Foo");
    text.append(BR);
    text.append("---");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  Foo");
    text.append(BR);
    text.append("-----");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  Foo");
    text.append(BR);
    text.append("  ===");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h2>\\s*Foo\\s*</h2>\\s*\\s*");
    sb.append("\\s*<h2>\\s*Foo\\s*</h2>\\s*\\s*");
    sb.append("\\s*<h1>\\s*Foo\\s*</h1>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    Foo");
    text.append(BR);
    text.append("    ---");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("    Foo");
    text.append(BR);
    text.append("---");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*Foo\\s*");
    sb.append("---\\s*");
    sb.append("\\s*");
    sb.append("Foo\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo");
    text.append(BR);
    text.append("   ----      ");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h2>\\s*Foo\\s*</h2>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo");
    text.append(BR);
    text.append("     ---");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*Foo\\s*");
    sb.append("---\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo");
    text.append(BR);
    text.append("= =");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("Foo");
    text.append(BR);
    text.append("--- -");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*Foo\\s*");
    sb.append("= =\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*Foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo  ");
    text.append(BR);
    text.append("-----");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h2>\\s*Foo\\s*</h2>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo\\");
    text.append(BR);
    text.append("----");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h2>\\s*Foo\\\\\\s*</h2>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("`Foo");
    text.append(BR);
    text.append("----");
    text.append(BR);
    text.append("`");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("<a title=\"a lot");
    text.append(BR);
    text.append("---");
    text.append(BR);
    text.append("of dashes\"/>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h2>\\s*\\`Foo\\s*</h2>\\s*\\s*");
    sb.append("\\s*<p>\\s*\\`\\s*</p>\\s*\\s*");
    sb.append("\\s*<h2>\\s*&lt;a title=&quot;a lot\\s*</h2>\\s*\\s*");
    sb.append("\\s*<p>\\s*of dashes&quot;/&gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> Foo");
    text.append(BR);
    text.append("---");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*Foo\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo");
    text.append(BR);
    text.append("Bar");
    text.append(BR);
    text.append("---");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("Foo");
    text.append(BR);
    text.append("Bar");
    text.append(BR);
    text.append("===");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*Foo\\s*");
    sb.append("Bar\\s*</p>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    sb.append("\\s*<p>\\s*Foo\\s*");
    sb.append("Bar\\s*");
    sb.append("===\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("---");
    text.append(BR);
    text.append("Foo");
    text.append(BR);
    text.append("---");
    text.append(BR);
    text.append("Bar");
    text.append(BR);
    text.append("---");
    text.append(BR);
    text.append("Baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<hr />\\s*\\s*");
    sb.append("\\s*<h2>\\s*Foo\\s*</h2>\\s*\\s*");
    sb.append("\\s*<h2>\\s*Bar\\s*</h2>\\s*\\s*");
    sb.append("\\s*<p>\\s*Baz\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("");
    text.append(BR);
    text.append("====");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*====\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders15() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("---");
    text.append(BR);
    text.append("---");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<hr />\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders16() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- foo");
    text.append(BR);
    text.append("-----");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders17() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    foo");
    text.append(BR);
    text.append("---");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*foo\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders18() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> foo");
    text.append(BR);
    text.append("-----");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSetextHeaders19() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("\\> foo");
    text.append(BR);
    text.append("------");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h2>\\s*&gt; foo\\s*</h2>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testIndentedCodeBlocks01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    a simple");
    text.append(BR);
    text.append("      indented code block");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*a simple\\s*");
    sb.append("  indented code block\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testIndentedCodeBlocks02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    <a/>");
    text.append(BR);
    text.append("    *hi*");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("    - one");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*&lt;a/&gt;\\s*");
    sb.append("\\*hi\\*\\s*");
    sb.append("\\s*");
    sb.append("- one\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testIndentedCodeBlocks03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    chunk1");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("    chunk2");
    text.append(BR);
    text.append("  ");
    text.append(BR);
    text.append(" ");
    text.append(BR);
    text.append(" ");
    text.append(BR);
    text.append("    chunk3");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*chunk1\\s*");
    sb.append("\\s*");
    sb.append("chunk2\\s*");
    sb.append("\\s*");
    sb.append("\\s*");
    sb.append("\\s*");
    sb.append("chunk3\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testIndentedCodeBlocks04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    chunk1");
    text.append(BR);
    text.append("      ");
    text.append(BR);
    text.append("      chunk2");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*chunk1\\s*");
    sb.append("  \\s*");
    sb.append("  chunk2\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testIndentedCodeBlocks05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo");
    text.append(BR);
    text.append("    bar");
    text.append(BR);
    text.append("");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*Foo\\s*");
    sb.append("bar\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testIndentedCodeBlocks06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    foo");
    text.append(BR);
    text.append("bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*foo\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testIndentedCodeBlocks07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("# Header");
    text.append(BR);
    text.append("    foo");
    text.append(BR);
    text.append("Header");
    text.append(BR);
    text.append("------");
    text.append(BR);
    text.append("    foo");
    text.append(BR);
    text.append("----");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h1>\\s*Header\\s*</h1>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*foo\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<h2>\\s*Header\\s*</h2>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*foo\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testIndentedCodeBlocks08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("        foo");
    text.append(BR);
    text.append("    bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*    foo\\s*");
    sb.append("bar\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testIndentedCodeBlocks09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("");
    text.append(BR);
    text.append("    ");
    text.append(BR);
    text.append("    foo");
    text.append(BR);
    text.append("    ");
    text.append(BR);
    text.append("");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*foo\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testIndentedCodeBlocks10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    foo  ");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*foo  \\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("```");
    text.append(BR);
    text.append("<");
    text.append(BR);
    text.append(" >");
    text.append(BR);
    text.append("```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*&lt;\\s*");
    sb.append(" &gt;\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("~~~");
    text.append(BR);
    text.append("<");
    text.append(BR);
    text.append(" >");
    text.append(BR);
    text.append("~~~");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*&lt;\\s*");
    sb.append(" &gt;\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("```");
    text.append(BR);
    text.append("aaa");
    text.append(BR);
    text.append("~~~");
    text.append(BR);
    text.append("```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*aaa\\s*");
    sb.append("~~~\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("~~~");
    text.append(BR);
    text.append("aaa");
    text.append(BR);
    text.append("```");
    text.append(BR);
    text.append("~~~");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*aaa\\s*");
    sb.append("\\`\\`\\`\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("````");
    text.append(BR);
    text.append("aaa");
    text.append(BR);
    text.append("```");
    text.append(BR);
    text.append("``````");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*aaa\\s*");
    sb.append("\\`\\`\\`\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("~~~~");
    text.append(BR);
    text.append("aaa");
    text.append(BR);
    text.append("~~~");
    text.append(BR);
    text.append("~~~~");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*aaa\\s*");
    sb.append("~~~\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("`````");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("```");
    text.append(BR);
    text.append("aaa");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*\\s*");
    sb.append("\\`\\`\\`\\s*");
    sb.append("aaa\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("```");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  ");
    text.append(BR);
    text.append("```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*\\s*");
    sb.append("  \\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("```");
    text.append(BR);
    text.append("```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(" ```");
    text.append(BR);
    text.append(" aaa");
    text.append(BR);
    text.append("aaa");
    text.append(BR);
    text.append("```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*aaa\\s*");
    sb.append("aaa\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("  ```");
    text.append(BR);
    text.append("aaa");
    text.append(BR);
    text.append("  aaa");
    text.append(BR);
    text.append("aaa");
    text.append(BR);
    text.append("  ```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*aaa\\s*");
    sb.append("aaa\\s*");
    sb.append("aaa\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("   ```");
    text.append(BR);
    text.append("   aaa");
    text.append(BR);
    text.append("    aaa");
    text.append(BR);
    text.append("  aaa");
    text.append(BR);
    text.append("   ```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*aaa\\s*");
    sb.append(" aaa\\s*");
    sb.append("aaa\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    ```");
    text.append(BR);
    text.append("    aaa");
    text.append(BR);
    text.append("    ```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*\\`\\`\\`\\s*");
    sb.append("aaa\\s*");
    sb.append("\\`\\`\\`\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks15() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("``` ```");
    text.append(BR);
    text.append("aaa");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*\\s*</code>\\s*\\s*");
    sb.append("aaa\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks16() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("~~~~~~");
    text.append(BR);
    text.append("aaa");
    text.append(BR);
    text.append("~~~ ~~");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*aaa\\s*");
    sb.append("~~~ ~~\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks17() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo");
    text.append(BR);
    text.append("```");
    text.append(BR);
    text.append("bar");
    text.append(BR);
    text.append("```");
    text.append(BR);
    text.append("baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*bar\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<p>\\s*baz\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks18() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo");
    text.append(BR);
    text.append("---");
    text.append(BR);
    text.append("~~~");
    text.append(BR);
    text.append("bar");
    text.append(BR);
    text.append("~~~");
    text.append(BR);
    text.append("# baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h2>\\s*foo\\s*</h2>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*bar\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<h1>\\s*baz\\s*</h1>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks19() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("```ruby");
    text.append(BR);
    text.append("def foo(x)");
    text.append(BR);
    text.append("  return 3");
    text.append(BR);
    text.append("end");
    text.append(BR);
    text.append("```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code class=\"language-ruby\">\\s*def foo\\(x\\)\\s*");
    sb.append("  return 3\\s*");
    sb.append("end\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks20() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("~~~~    ruby startline=3 $%@#$");
    text.append(BR);
    text.append("def foo(x)");
    text.append(BR);
    text.append("  return 3");
    text.append(BR);
    text.append("end");
    text.append(BR);
    text.append("~~~~~~~");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code class=\"language-ruby\">\\s*def foo\\(x\\)\\s*");
    sb.append("  return 3\\s*");
    sb.append("end\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks21() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("````;");
    text.append(BR);
    text.append("````");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code class=\"language-;\">\\s*\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks22() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("``` aa ```");
    text.append(BR);
    text.append("foo");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*aa\\s*</code>\\s*\\s*");
    sb.append("foo\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testFencedCodeBlocks23() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("```");
    text.append(BR);
    text.append("``` aaa");
    text.append(BR);
    text.append("```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*\\`\\`\\` aaa\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<table>");
    text.append(BR);
    text.append("  <tr>");
    text.append(BR);
    text.append("    <td>");
    text.append(BR);
    text.append("           hi");
    text.append(BR);
    text.append("    </td>");
    text.append(BR);
    text.append("  </tr>");
    text.append(BR);
    text.append("</table>");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("okay.");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<table>\\s*\\s*");
    sb.append("  \\s*<tr>\\s*\\s*");
    sb.append("    \\s*<td>\\s*\\s*");
    sb.append("           hi\\s*");
    sb.append("    \\s*</td>\\s*\\s*");
    sb.append("  \\s*</tr>\\s*\\s*");
    sb.append("\\s*</table>\\s*\\s*");
    sb.append("\\s*<p>\\s*okay\\.\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(" <div>");
    text.append(BR);
    text.append("  *hello*");
    text.append(BR);
    text.append("         <foo><a>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append(" \\s*<div>\\s*\\s*");
    sb.append("  \\*hello\\*\\s*");
    sb.append("         \\s*<foo>\\s*\\s*<a>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<DIV CLASS=\"foo\">");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("*Markdown*");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("</DIV>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<DIV CLASS=\"foo\">\\s*\\s*");
    sb.append("\\s*<p>\\s*\\s*<em>\\s*Markdown\\s*</em>\\s*\\s*</p>\\s*\\s*");
    sb.append("\\s*</DIV>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<div></div>");
    text.append(BR);
    text.append("``` c");
    text.append(BR);
    text.append("int x = 33;");
    text.append(BR);
    text.append("```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<div>\\s*\\s*</div>\\s*\\s*");
    sb.append("\\`\\`\\` c\\s*");
    sb.append("int x = 33;\\s*");
    sb.append("\\`\\`\\`\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<!-- Foo");
    text.append(BR);
    text.append("bar");
    text.append(BR);
    text.append("   baz -->");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<!-- Foo\\s*");
    sb.append("bar\\s*");
    sb.append("   baz -->\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<?php");
    text.append(BR);
    text.append("  echo '>';");
    text.append(BR);
    text.append("?>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<\\?php\\s*");
    sb.append("  echo '>\\s*';\\s*");
    sb.append("\\?>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<![CDATA[");
    text.append(BR);
    text.append("function matchwo(a,b)");
    text.append(BR);
    text.append("{");
    text.append(BR);
    text.append("if (a < b && a < 0) then");
    text.append(BR);
    text.append("  {");
    text.append(BR);
    text.append("  return 1;");
    text.append(BR);
    text.append("  }");
    text.append(BR);
    text.append("else");
    text.append(BR);
    text.append("  {");
    text.append(BR);
    text.append("  return 0;");
    text.append(BR);
    text.append("  }");
    text.append(BR);
    text.append("}");
    text.append(BR);
    text.append("]]>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<!\\[CDATA\\[\\s*");
    sb.append("function matchwo\\(a,b\\)\\s*");
    sb.append("\\{\\s*");
    sb.append("if \\(a \\s*< b && a \\s*< 0\\) then\\s*");
    sb.append("  \\{\\s*");
    sb.append("  return 1;\\s*");
    sb.append("  \\}\\s*");
    sb.append("else\\s*");
    sb.append("  \\{\\s*");
    sb.append("  return 0;\\s*");
    sb.append("  \\}\\s*");
    sb.append("\\}\\s*");
    sb.append("\\]\\]>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("  <!-- foo -->");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("    <!-- foo -->");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("  \\s*<!-- foo -->\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*&lt;!-- foo --&gt;\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo");
    text.append(BR);
    text.append("<div>");
    text.append(BR);
    text.append("bar");
    text.append(BR);
    text.append("</div>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*Foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<div>\\s*\\s*");
    sb.append("bar\\s*");
    sb.append("\\s*</div>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<div>");
    text.append(BR);
    text.append("bar");
    text.append(BR);
    text.append("</div>");
    text.append(BR);
    text.append("*foo*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<div>\\s*\\s*");
    sb.append("bar\\s*");
    sb.append("\\s*</div>\\s*\\s*");
    sb.append("\\*foo\\*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<div class");
    text.append(BR);
    text.append("foo");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<div class\\s*");
    sb.append("foo\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<div>");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("*Emphasized* text.");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("</div>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<div>\\s*\\s*");
    sb.append("\\s*<p>\\s*\\s*<em>\\s*Emphasized\\s*</em>\\s* text\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*</div>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<div>");
    text.append(BR);
    text.append("*Emphasized* text.");
    text.append(BR);
    text.append("</div>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<div>\\s*\\s*");
    sb.append("\\*Emphasized\\* text\\.\\s*");
    sb.append("\\s*</div>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHtmlBlocks14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<table>");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("<tr>");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("<td>");
    text.append(BR);
    text.append("Hi");
    text.append(BR);
    text.append("</td>");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("</tr>");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("</table>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<table>\\s*\\s*");
    sb.append("\\s*<tr>\\s*\\s*");
    sb.append("\\s*<td>\\s*\\s*");
    sb.append("Hi\\s*");
    sb.append("\\s*</td>\\s*\\s*");
    sb.append("\\s*</tr>\\s*\\s*");
    sb.append("\\s*</table>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]: /url \"title\"");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("   [foo]: ");
    text.append(BR);
    text.append("      /url  ");
    text.append(BR);
    text.append("           'the title'  ");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"the title\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[Foo*bar\\]]:my_(url) 'title (with parens)'");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[Foo*bar\\]]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"my_\\(url\\)\" title=\"title \\(with parens\\)\">\\s*Foo\\*bar\\]\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[Foo bar]:");
    text.append(BR);
    text.append("<my url>");
    text.append(BR);
    text.append("'title'");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[Foo bar]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"my%20url\" title=\"title\">\\s*Foo bar\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]:");
    text.append(BR);
    text.append("/url");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]:");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[foo\\]:\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*\\[foo\\]\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: url");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"url\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: first");
    text.append(BR);
    text.append("[foo]: second");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"first\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[FOO]: /url");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[Foo]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\">\\s*Foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[ΑΓΩ]: /φου");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[αγω]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/%CF%86%CE%BF%CF%85\">\\s*αγω\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]: /url");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]: /url \"title\" ok");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[foo\\]: /url &quot;title&quot; ok\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    [foo]: /url \"title\"");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*\\[foo\\]: /url &quot;title&quot;\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<p>\\s*\\[foo\\]\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("```");
    text.append(BR);
    text.append("[foo]: /url");
    text.append(BR);
    text.append("```");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*\\[foo\\]: /url\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<p>\\s*\\[foo\\]\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions15() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo");
    text.append(BR);
    text.append("[bar]: /baz");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[bar]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*Foo\\s*");
    sb.append("\\[bar\\]: /baz\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*\\[bar\\]\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions16() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("# [Foo]");
    text.append(BR);
    text.append("[foo]: /url");
    text.append(BR);
    text.append("> bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<h1>\\s*\\s*<a href=\"/url\">\\s*Foo\\s*</a>\\s*\\s*</h1>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions17() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]: /foo-url \"foo\"");
    text.append(BR);
    text.append("[bar]: /bar-url");
    text.append(BR);
    text.append("  \"bar\"");
    text.append(BR);
    text.append("[baz]: /baz-url");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo],");
    text.append(BR);
    text.append("[bar],");
    text.append(BR);
    text.append("[baz]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/foo-url\" title=\"foo\">\\s*foo\\s*</a>\\s*,\\s*");
    sb.append("\\s*<a href=\"/bar-url\" title=\"bar\">\\s*bar\\s*</a>\\s*,\\s*");
    sb.append("\\s*<a href=\"/baz-url\">\\s*baz\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinkReferenceDefinitions18() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("> [foo]: /url");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testParagraphs01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("aaa");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("bbb");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*aaa\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*bbb\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testParagraphs02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("aaa");
    text.append(BR);
    text.append("bbb");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("ccc");
    text.append(BR);
    text.append("ddd");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*aaa\\s*");
    sb.append("bbb\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*ccc\\s*");
    sb.append("ddd\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testParagraphs03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("aaa");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("bbb");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*aaa\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*bbb\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testParagraphs04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("  aaa");
    text.append(BR);
    text.append(" bbb");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*aaa\\s*");
    sb.append("bbb\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testParagraphs05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("aaa");
    text.append(BR);
    text.append("             bbb");
    text.append(BR);
    text.append("                                       ccc");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*aaa\\s*");
    sb.append("bbb\\s*");
    sb.append("ccc\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testParagraphs06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("   aaa");
    text.append(BR);
    text.append("bbb");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*aaa\\s*");
    sb.append("bbb\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testParagraphs07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    aaa");
    text.append(BR);
    text.append("bbb");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*aaa\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<p>\\s*bbb\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testParagraphs08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("aaa     ");
    text.append(BR);
    text.append("bbb     ");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*aaa\\s*<br />\\s*\\s*");
    sb.append("bbb\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlankLines01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("  ");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("aaa");
    text.append(BR);
    text.append("  ");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("# aaa");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  ");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*aaa\\s*</p>\\s*\\s*");
    sb.append("\\s*<h1>\\s*aaa\\s*</h1>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> # Foo");
    text.append(BR);
    text.append("> bar");
    text.append(BR);
    text.append("> baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<h1>\\s*Foo\\s*</h1>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*");
    sb.append("baz\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("># Foo");
    text.append(BR);
    text.append(">bar");
    text.append(BR);
    text.append("> baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<h1>\\s*Foo\\s*</h1>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*");
    sb.append("baz\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("   > # Foo");
    text.append(BR);
    text.append("   > bar");
    text.append(BR);
    text.append(" > baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<h1>\\s*Foo\\s*</h1>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*");
    sb.append("baz\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    > # Foo");
    text.append(BR);
    text.append("    > bar");
    text.append(BR);
    text.append("    > baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*&gt; # Foo\\s*");
    sb.append("&gt; bar\\s*");
    sb.append("&gt; baz\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> # Foo");
    text.append(BR);
    text.append("> bar");
    text.append(BR);
    text.append("baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<h1>\\s*Foo\\s*</h1>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*");
    sb.append("baz\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> bar");
    text.append(BR);
    text.append("baz");
    text.append(BR);
    text.append("> foo");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*");
    sb.append("baz\\s*");
    sb.append("foo\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> foo");
    text.append(BR);
    text.append("---");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> - foo");
    text.append(BR);
    text.append("- bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*bar\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(">     foo");
    text.append(BR);
    text.append("    bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*foo\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*bar\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> ```");
    text.append(BR);
    text.append("foo");
    text.append(BR);
    text.append("```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(">");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(">");
    text.append(BR);
    text.append(">  ");
    text.append(BR);
    text.append("> ");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(">");
    text.append(BR);
    text.append("> foo");
    text.append(BR);
    text.append(">  ");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("> bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes15() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> foo");
    text.append(BR);
    text.append("> bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*foo\\s*");
    sb.append("bar\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes16() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> foo");
    text.append(BR);
    text.append(">");
    text.append(BR);
    text.append("> bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes17() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo");
    text.append(BR);
    text.append("> bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes18() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> aaa");
    text.append(BR);
    text.append("***");
    text.append(BR);
    text.append("> bbb");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*aaa\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*<hr />\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*bbb\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes19() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> bar");
    text.append(BR);
    text.append("baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*");
    sb.append("baz\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes20() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> bar");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*baz\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes21() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> bar");
    text.append(BR);
    text.append(">");
    text.append(BR);
    text.append("baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*baz\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes22() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> > > foo");
    text.append(BR);
    text.append("bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*foo\\s*");
    sb.append("bar\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes23() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(">>> foo");
    text.append(BR);
    text.append("> bar");
    text.append(BR);
    text.append(">>baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*foo\\s*");
    sb.append("bar\\s*");
    sb.append("baz\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBlockQuotes24() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(">     code");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append(">    not code");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*not code\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("A paragraph");
    text.append(BR);
    text.append("with two lines.");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("    indented code");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("> A block quote.");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*A paragraph\\s*");
    sb.append("with two lines\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*indented code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*A block quote\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("1.  A paragraph");
    text.append(BR);
    text.append("    with two lines.");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("        indented code");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("    > A block quote.");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*A paragraph\\s*");
    sb.append("with two lines\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*indented code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*A block quote\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- one");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append(" two");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*one\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<p>\\s*two\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- one");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  two");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*one\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*two\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(" -    one");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("     two");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*one\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s* two\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(" -    one");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("      two");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*one\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*two\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("   > > 1.  one");
    text.append(BR);
    text.append(">>");
    text.append(BR);
    text.append(">>     two");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*one\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*two\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(">>- one");
    text.append(BR);
    text.append(">>");
    text.append(BR);
    text.append("  >  > two");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*one\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<p>\\s*two\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  bar");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("- foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  bar");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("- ```");
    text.append(BR);
    text.append("  foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  bar");
    text.append(BR);
    text.append("  ```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*foo\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<pre>\\s*\\s*<code>\\s*foo\\s*");
    sb.append("\\s*");
    sb.append("\\s*");
    sb.append("bar\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("1.  foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("    ```");
    text.append(BR);
    text.append("    bar");
    text.append(BR);
    text.append("    ```");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("    baz");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("    > bam");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*bar\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<p>\\s*baz\\s*</p>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*bam\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("      bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*bar\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("  10.  foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("           bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol start=\"10\">\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*bar\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    indented code");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("paragraph");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("    more code");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*indented code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<p>\\s*paragraph\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*more code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("1.     indented code");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("   paragraph");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("       more code");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<pre>\\s*\\s*<code>\\s*indented code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<p>\\s*paragraph\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*more code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems15() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("1.      indented code");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("   paragraph");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("       more code");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<pre>\\s*\\s*<code>\\s* indented code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<p>\\s*paragraph\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*more code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems16() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("   foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems17() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("-    foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems18() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("-  foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("   bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems19() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append(" 1.  A paragraph");
    text.append(BR);
    text.append("     with two lines.");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("         indented code");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("     > A block quote.");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*A paragraph\\s*");
    sb.append("with two lines\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*indented code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*A block quote\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems20() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("  1.  A paragraph");
    text.append(BR);
    text.append("      with two lines.");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("          indented code");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("      > A block quote.");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*A paragraph\\s*");
    sb.append("with two lines\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*indented code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*A block quote\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems21() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("   1.  A paragraph");
    text.append(BR);
    text.append("       with two lines.");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("           indented code");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("       > A block quote.");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*A paragraph\\s*");
    sb.append("with two lines\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*indented code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*A block quote\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems22() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    1.  A paragraph");
    text.append(BR);
    text.append("        with two lines.");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("            indented code");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("        > A block quote.");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*1\\.  A paragraph\\s*");
    sb.append("    with two lines\\.\\s*");
    sb.append("\\s*");
    sb.append("        indented code\\s*");
    sb.append("\\s*");
    sb.append("    &gt; A block quote\\.\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems23() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("  1.  A paragraph");
    text.append(BR);
    text.append("with two lines.");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("          indented code");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("      > A block quote.");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*A paragraph\\s*");
    sb.append("with two lines\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*indented code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*A block quote\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems24() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("  1.  A paragraph");
    text.append(BR);
    text.append("    with two lines.");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*A paragraph\\s*");
    sb.append("with two lines\\.\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems25() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> 1. > Blockquote");
    text.append(BR);
    text.append("continued here.");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*Blockquote\\s*");
    sb.append("continued here\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems26() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("> 1. > Blockquote");
    text.append(BR);
    text.append("> continued here.");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*Blockquote\\s*");
    sb.append("continued here\\.\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems27() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- foo");
    text.append(BR);
    text.append("  - bar");
    text.append(BR);
    text.append("    - baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*bar\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*baz\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems28() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- foo");
    text.append(BR);
    text.append(" - bar");
    text.append(BR);
    text.append("  - baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*bar\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*baz\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems29() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("10) foo");
    text.append(BR);
    text.append("    - bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol start=\"10\">\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*bar\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems30() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("10) foo");
    text.append(BR);
    text.append("   - bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol start=\"10\">\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*bar\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems31() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- - foo");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems32() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("1. - 2. foo");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<ol start=\"2\">\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems33() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- foo");
    text.append(BR);
    text.append("-");
    text.append(BR);
    text.append("- bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*bar\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems34() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("-");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testListItems35() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- # Foo");
    text.append(BR);
    text.append("- Bar");
    text.append(BR);
    text.append("  ---");
    text.append(BR);
    text.append("  baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<h1>\\s*Foo\\s*</h1>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<h2>\\s*Bar\\s*</h2>\\s*\\s*");
    sb.append("\\s*<p>\\s*baz\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- foo");
    text.append(BR);
    text.append("- bar");
    text.append(BR);
    text.append("+ baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*bar\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*baz\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("1. foo");
    text.append(BR);
    text.append("2. bar");
    text.append(BR);
    text.append("3) baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ol>\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*bar\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    sb.append("\\s*<ol start=\"3\">\\s*\\s*");
    sb.append("\\s*<li>\\s*baz\\s*</li>\\s*\\s*");
    sb.append("\\s*</ol>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("- bar");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("- baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*foo\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*bar\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*baz\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  bar");
    text.append(BR);
    text.append("- baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<p>\\s*bar\\s*</p>\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*baz\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- foo");
    text.append(BR);
    text.append("  - bar");
    text.append(BR);
    text.append("    - baz");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("      bim");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*bar\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*baz\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*  bim\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- foo");
    text.append(BR);
    text.append("- bar");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("- baz");
    text.append(BR);
    text.append("- bim");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*foo\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*bar\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*baz\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*bim\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("-   foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("    notcode");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("-   foo");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("    code");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*notcode\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*foo\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*code\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- a");
    text.append(BR);
    text.append(" - b");
    text.append(BR);
    text.append("  - c");
    text.append(BR);
    text.append("   - d");
    text.append(BR);
    text.append("  - e");
    text.append(BR);
    text.append(" - f");
    text.append(BR);
    text.append("- g");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*a\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*b\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*c\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*d\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*e\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*f\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*g\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- a");
    text.append(BR);
    text.append("- b");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("- c");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*a\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*b\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*c\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("* a");
    text.append(BR);
    text.append("*");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("* c");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*a\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*c\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- a");
    text.append(BR);
    text.append("- b");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  c");
    text.append(BR);
    text.append("- d");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*a\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*b\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*c\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*d\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- a");
    text.append(BR);
    text.append("- b");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  [ref]: /url");
    text.append(BR);
    text.append("- d");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*a\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*b\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*d\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- a");
    text.append(BR);
    text.append("- ```");
    text.append(BR);
    text.append("  b");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  ```");
    text.append(BR);
    text.append("- c");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*a\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<pre>\\s*\\s*<code>\\s*b\\s*");
    sb.append("\\s*");
    sb.append("\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*c\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- a");
    text.append(BR);
    text.append("  - b");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("    c");
    text.append(BR);
    text.append("- d");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*a\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*b\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*c\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*d\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists15() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("* a");
    text.append(BR);
    text.append("  > b");
    text.append(BR);
    text.append("  >");
    text.append(BR);
    text.append("* c");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*a\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*b\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*c\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists16() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- a");
    text.append(BR);
    text.append("  > b");
    text.append(BR);
    text.append("  ```");
    text.append(BR);
    text.append("  c");
    text.append(BR);
    text.append("  ```");
    text.append(BR);
    text.append("- d");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*a\\s*");
    sb.append("\\s*<blockquote>\\s*\\s*");
    sb.append("\\s*<p>\\s*b\\s*</p>\\s*\\s*");
    sb.append("\\s*</blockquote>\\s*\\s*");
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*c\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*d\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists17() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- a");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*a\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists18() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- a");
    text.append(BR);
    text.append("  - b");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*a\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*b\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists19() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("* foo");
    text.append(BR);
    text.append("  * bar");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("  baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*foo\\s*</p>\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*bar\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    sb.append("\\s*<p>\\s*baz\\s*</p>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLists20() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("- a");
    text.append(BR);
    text.append("  - b");
    text.append(BR);
    text.append("  - c");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("- d");
    text.append(BR);
    text.append("  - e");
    text.append(BR);
    text.append("  - f");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*a\\s*</p>\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*b\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*c\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*\\s*<p>\\s*d\\s*</p>\\s*\\s*");
    sb.append("\\s*<ul>\\s*\\s*");
    sb.append("\\s*<li>\\s*e\\s*</li>\\s*\\s*");
    sb.append("\\s*<li>\\s*f\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*</li>\\s*\\s*");
    sb.append("\\s*</ul>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testInlines01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("`hi`lo`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*hi\\s*</code>\\s*lo\\`\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBackslashEscapes01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\=\\>\\?\\@\\[\\\\\\]\\^\\_\\`\\{\\|\\}\\~");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*!&quot;#\\$%&amp;'\\(\\)\\*\\+,-\\./:;&lt;=&gt;\\?@\\[\\\\\\]^_\\`\\{|\\}~\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBackslashEscapes02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("\\\t\\A\\a\\ \\3\\φ\\«");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\\\   \\\\A\\\\a\\\\ \\\\3\\\\φ\\\\«\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBackslashEscapes03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("\\*not emphasized*");
    text.append(BR);
    text.append("\\<br/> not a tag");
    text.append(BR);
    text.append("\\[not a link](/foo)");
    text.append(BR);
    text.append("\\`not code`");
    text.append(BR);
    text.append("1\\. not a list");
    text.append(BR);
    text.append("\\* not a list");
    text.append(BR);
    text.append("\\# not a header");
    text.append(BR);
    text.append("\\[foo]: /url \"not a reference\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*not emphasized\\*\\s*");
    sb.append("&lt;br/&gt; not a tag\\s*");
    sb.append("\\[not a link\\]\\(/foo\\)\\s*");
    sb.append("\\`not code\\`\\s*");
    sb.append("1\\. not a list\\s*");
    sb.append("\\* not a list\\s*");
    sb.append("# not a header\\s*");
    sb.append("\\[foo\\]: /url &quot;not a reference&quot;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBackslashEscapes04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("\\\\*emphasis*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\\\\\s*<em>\\s*emphasis\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBackslashEscapes05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo\\");
    text.append(BR);
    text.append("bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo\\s*<br />\\s*\\s*");
    sb.append("bar\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBackslashEscapes06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("`` \\[\\` ``");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*\\\\\\[\\\\\\`\\s*</code>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBackslashEscapes07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    \\[\\]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*\\\\\\[\\\\\\]\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBackslashEscapes08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("~~~");
    text.append(BR);
    text.append("\\[\\]");
    text.append(BR);
    text.append("~~~");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*\\\\\\[\\\\\\]\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBackslashEscapes09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<http://example.com?find=\\*>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"http://example\\.com\\?find=%5C\\*\">\\s*http://example\\.com\\?find=\\\\\\*\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBackslashEscapes10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a href=\"/bar\\/)\">");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/bar\\\\/\\)\">\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBackslashEscapes11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo](/bar\\* \"ti\\*tle\")");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/bar\\*\" title=\"ti\\*tle\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBackslashEscapes12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /bar\\* \"ti\\*tle\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/bar\\*\" title=\"ti\\*tle\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testBackslashEscapes13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("``` foo\\+bar");
    text.append(BR);
    text.append("foo");
    text.append(BR);
    text.append("```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code class=\"language-foo\\+bar\">\\s*foo\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEntities01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("&nbsp; &amp; &copy; &AElig; &Dcaron; &frac34; &HilbertSpace; &DifferentialD; &ClockwiseContourIntegral;");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*  &amp; © Æ Ď ¾ ℋ ⅆ ∲\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEntities02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("&#35; &#1234; &#992; &#98765432;");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*# Ӓ Ϡ �\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEntities03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("&#X22; &#XD06; &#xcab;");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&quot; ആ ಫ\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEntities04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("&nbsp &x; &#; &#x; &ThisIsWayTooLongToBeAnEntityIsntIt; &hi?;");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&amp;nbsp &amp;x; &amp;#; &amp;#x; &amp;ThisIsWayTooLongToBeAnEntityIsntIt; &amp;hi\\?;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEntities05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("&copy");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&amp;copy\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEntities06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("&MadeUpEntity;");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&amp;MadeUpEntity;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEntities07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a href=\"&ouml;&ouml;.html\">");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"&ouml;&ouml;\\.html\">\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEntities08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo](/f&ouml;&ouml; \"f&ouml;&ouml;\")");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/f%C3%B6%C3%B6\" title=\"föö\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEntities09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /f&ouml;&ouml; \"f&ouml;&ouml;\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/f%C3%B6%C3%B6\" title=\"föö\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEntities10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("``` f&ouml;&ouml;");
    text.append(BR);
    text.append("foo");
    text.append(BR);
    text.append("```");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code class=\"language-föö\">\\s*foo\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEntities11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("`f&ouml;&ouml;`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*f&amp;ouml;&amp;ouml;\\s*</code>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEntities12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("    f&ouml;f&ouml;");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<pre>\\s*\\s*<code>\\s*f&amp;ouml;f&amp;ouml;\\s*");
    sb.append("\\s*</code>\\s*\\s*</pre>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testCodeSpan01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("`foo`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*foo\\s*</code>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testCodeSpan02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("`` foo ` bar  ``");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*foo \\` bar\\s*</code>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testCodeSpan03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("` `` `");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*\\`\\`\\s*</code>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testCodeSpan04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("``");
    text.append(BR);
    text.append("foo");
    text.append(BR);
    text.append("``");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*foo\\s*</code>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testCodeSpan05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("`foo   bar");
    text.append(BR);
    text.append("  baz`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*foo bar baz\\s*</code>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testCodeSpan06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("`foo `` bar`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*foo \\`\\` bar\\s*</code>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testCodeSpan07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("`foo\\`bar`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*foo\\\\\\s*</code>\\s*bar\\`\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testCodeSpan08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo`*`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*foo\\s*<code>\\s*\\*\\s*</code>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testCodeSpan09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[not a `link](/foo`)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[not a \\s*<code>\\s*link\\]\\(/foo\\s*</code>\\s*\\)\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testCodeSpan10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<http://foo.bar.`baz>`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"http://foo\\.bar\\.%60baz\">\\s*http://foo\\.bar\\.\\`baz\\s*</a>\\s*\\`\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testCodeSpan11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a href=\"`\">`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"\\`\">\\s*\\`\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testCodeSpan12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("```foo``");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\`\\`\\`foo\\`\\`\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testCodeSpan13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("`foo");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\`foo\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo bar*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo bar\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_foo bar_");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo bar\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**foo bar**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo bar\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("__foo bar__");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo bar\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo");
    text.append(BR);
    text.append("bar*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo\\s*");
    sb.append("bar\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_foo");
    text.append(BR);
    text.append("bar_");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo\\s*");
    sb.append("bar\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**foo");
    text.append(BR);
    text.append("bar**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo\\s*");
    sb.append("bar\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("__foo");
    text.append(BR);
    text.append("bar__");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo\\s*");
    sb.append("bar\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo [bar](/url)*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo \\s*<a href=\"/url\">\\s*bar\\s*</a>\\s*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_foo [bar](/url)_");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo \\s*<a href=\"/url\">\\s*bar\\s*</a>\\s*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**foo [bar](/url)**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo \\s*<a href=\"/url\">\\s*bar\\s*</a>\\s*\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("__foo [bar](/url)__");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo \\s*<a href=\"/url\">\\s*bar\\s*</a>\\s*\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo [bar*](/url)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*foo \\s*<a href=\"/url\">\\s*bar\\*\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_foo [bar_](/url)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*_foo \\s*<a href=\"/url\">\\s*bar_\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis15() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**<a href=\"**\">");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*\\*\\s*<a href=\"\\*\\*\">\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis16() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("__<a href=\"__\">");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*__\\s*<a href=\"__\">\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis17() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*a `*`*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*a \\s*<code>\\s*\\*\\s*</code>\\s*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis18() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_a `_`_");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*a \\s*<code>\\s*_\\s*</code>\\s*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis19() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**a<http://foo.bar?q=**>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*\\*a\\s*<a href=\"http://foo\\.bar\\?q=\\*\\*\">\\s*http://foo\\.bar\\?q=\\*\\*\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis20() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("__a<http://foo.bar?q=__>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*__a\\s*<a href=\"http://foo\\.bar\\?q=__\">\\s*http://foo\\.bar\\?q=__\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis21() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("and * foo bar*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*and \\* foo bar\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis22() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_ foo bar_");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*_ foo bar_\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis23() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("and ** foo bar**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*and \\*\\* foo bar\\*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis24() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("__ foo bar__");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*__ foo bar__\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis25() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("and *foo bar *");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*and \\*foo bar \\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis26() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("and _foo bar _");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*and _foo bar _\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis27() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("and **foo bar **");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*and \\*\\*foo bar \\*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis28() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("and __foo bar __");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*and __foo bar __\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis29() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("****hi****");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*\\*\\*\\*hi\\*\\*\\*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis30() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_____hi_____");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*_____hi_____\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis31() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Sign here: _________");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*Sign here: _________\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis32() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("** is not an empty emphasis");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*\\* is not an empty emphasis\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis33() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**** is not an empty strong emphasis");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*\\*\\*\\* is not an empty strong emphasis\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis34() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*here is a \\**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*here is a \\*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis35() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("__this is a double underscore (`__`)__");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*this is a double underscore \\(\\s*<code>\\s*__\\s*</code>\\s*\\)\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis36() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*_*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*_\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis37() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_*_");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*\\*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis38() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*__*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*__\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis39() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_**_");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*\\*\\*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis40() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo*bar*baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo\\s*<em>\\s*bar\\s*</em>\\s*baz\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis41() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo_bar_baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo_bar_baz\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis42() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo__bar__baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo__bar__baz\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis43() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_foo_bar_baz_");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo_bar_baz\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis44() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("11*15*32");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*11\\s*<em>\\s*15\\s*</em>\\s*32\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis45() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("11_15_32");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*11_15_32\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis46() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_foo_bar_baz_");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo_bar_baz\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis47() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("__foo__bar__baz__");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo__bar__baz\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis48() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("***foo bar***");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*\\s*<em>\\s*foo bar\\s*</em>\\s*\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis49() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("___foo bar___");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*\\s*<em>\\s*foo bar\\s*</em>\\s*\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis50() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("***foo** bar*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*\\s*<strong>\\s*foo\\s*</strong>\\s* bar\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis51() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("___foo__ bar_");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*\\s*<strong>\\s*foo\\s*</strong>\\s* bar\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis52() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("***foo* bar**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*\\s*<em>\\s*foo\\s*</em>\\s* bar\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis53() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("___foo_ bar__");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*\\s*<em>\\s*foo\\s*</em>\\s* bar\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis54() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo **bar***");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo \\s*<strong>\\s*bar\\s*</strong>\\s*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis55() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_foo __bar___");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo \\s*<strong>\\s*bar\\s*</strong>\\s*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis56() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**foo *bar***");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo \\s*<em>\\s*bar\\s*</em>\\s*\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis57() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("__foo _bar___");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo \\s*<em>\\s*bar\\s*</em>\\s*\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis58() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo **bar***");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo \\s*<strong>\\s*bar\\s*</strong>\\s*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis59() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_foo __bar___");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo \\s*<strong>\\s*bar\\s*</strong>\\s*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis60() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo *bar* baz*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo \\s*<em>\\s*bar\\s*</em>\\s* baz\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis61() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_foo _bar_ baz_");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo \\s*<em>\\s*bar\\s*</em>\\s* baz\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis62() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**foo **bar** baz**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo \\s*<strong>\\s*bar\\s*</strong>\\s* baz\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis63() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("__foo __bar__ baz__");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo \\s*<strong>\\s*bar\\s*</strong>\\s* baz\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis64() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo **bar** baz*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo \\s*<strong>\\s*bar\\s*</strong>\\s* baz\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis65() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("_foo __bar__ baz_");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo \\s*<strong>\\s*bar\\s*</strong>\\s* baz\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis66() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**foo *bar* baz**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo \\s*<em>\\s*bar\\s*</em>\\s* baz\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis67() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("__foo _bar_ baz__");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo \\s*<em>\\s*bar\\s*</em>\\s* baz\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis68() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**foo, *bar*, baz**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo, \\s*<em>\\s*bar\\s*</em>\\s*, baz\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis69() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("__foo, _bar_, baz__");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo, \\s*<em>\\s*bar\\s*</em>\\s*, baz\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis70() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo**bar**baz*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo\\s*</em>\\s*\\s*<em>\\s*bar\\s*</em>\\s*\\s*<em>\\s*baz\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis71() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**foo*bar*baz**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*\\s*<em>\\s*foo\\s*</em>\\s*bar\\s*</em>\\s*baz\\*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis72() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**foo**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis73() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("****foo****");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*\\*\\*\\*foo\\*\\*\\*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis74() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*_foo_*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*\\s*<em>\\s*foo\\s*</em>\\s*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis75() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**__foo__**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*\\s*<strong>\\s*foo\\s*</strong>\\s*\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis76() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo\\s*</em>\\s*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis77() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo *bar**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo \\s*<em>\\s*bar\\s*</em>\\s*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis78() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**foo***");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*foo\\s*</strong>\\s*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis79() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("***foo* bar***");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*\\s*<em>\\s*foo\\s*</em>\\s* bar\\s*</strong>\\s*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis80() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("***foo** bar***");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*\\s*<strong>\\s*foo\\s*</strong>\\s* bar\\s*</em>\\s*\\*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis81() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo**bar***");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo\\s*</em>\\s*\\s*<em>\\s*bar\\s*</em>\\s*\\*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis82() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo****");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*foo\\*\\*\\*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis83() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo**");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("**foo*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo\\s*</em>\\s*\\*\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*\\*\\s*<em>\\s*foo\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis84() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo *bar**");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("**foo* bar*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo \\s*<em>\\s*bar\\s*</em>\\s*\\s*</em>\\s*\\s*</p>\\s*\\s*");
    sb.append("\\s*<p>\\s*\\s*<em>\\s*\\s*<em>\\s*foo\\s*</em>\\s* bar\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis85() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*bar***");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*bar\\s*</em>\\s*\\*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis86() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("***foo*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*\\*\\s*<em>\\s*foo\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis87() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**bar***");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<strong>\\s*bar\\s*</strong>\\s*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis88() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("***foo**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*\\s*<strong>\\s*foo\\s*</strong>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis89() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("***foo *bar*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*\\*\\*foo \\s*<em>\\s*bar\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis90() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo _bar* baz_");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo _bar\\s*</em>\\s* baz_\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis91() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("**foo bar* baz**");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*\\s*<em>\\s*foo bar\\s*</em>\\s* baz\\s*</em>\\s*\\*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis92() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*[foo*](bar)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*\\s*<a href=\"bar\">\\s*foo\\*\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis93() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*![foo*](bar)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*\\s*<img src=\"bar\" alt=\"foo\\*\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis94() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*<img src=\"foo\" title=\"*\"/>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*\\s*<img src=\"foo\" title=\"\\*\"/>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testEmphasisAndStrongEmphasis95() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*a`a*`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*a\\s*<code>\\s*a\\*\\s*</code>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](/uri \"title\")");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/uri\" title=\"title\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](/uri)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/uri\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link]()");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](<>)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](/my uri)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[link\\]\\(/my uri\\)\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](</my uri>)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/my%20uri\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](foo");
    text.append(BR);
    text.append("bar)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[link\\]\\(foo\\s*");
    sb.append("bar\\)\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link]((foo)and(bar))");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"\\(foo\\)and\\(bar\\)\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](foo(and(bar)))");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[link\\]\\(foo\\(and\\(bar\\)\\)\\)\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](foo(and\\(bar\\)))");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"foo\\(and\\(bar\\)\\)\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](<foo(and(bar))>)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"foo\\(and\\(bar\\)\\)\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](foo\\)\\:)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"foo\\):\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](foo%20b&auml;)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"foo%20b%C3%A4\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](\"title\")");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"%22title%22\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks15() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](/url \"title\")");
    text.append(BR);
    text.append("[link](/url 'title')");
    text.append(BR);
    text.append("[link](/url (title))");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*link\\s*</a>\\s*\\s*");
    sb.append("\\s*<a href=\"/url\" title=\"title\">\\s*link\\s*</a>\\s*\\s*");
    sb.append("\\s*<a href=\"/url\" title=\"title\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks16() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](/url \"title \\\"&quot;\")");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title &quot;&quot;\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks17() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](/url \"title \"and\" title\")");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[link\\]\\(/url &quot;title &quot;and&quot; title&quot;\\)\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks18() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](/url 'title \"and\" title')");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title &quot;and&quot; title\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks19() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link](   /uri");
    text.append(BR);
    text.append("  \"title\"  )");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/uri\" title=\"title\">\\s*link\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks20() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[link] (/uri)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[link\\] \\(/uri\\)\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks21() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo <bar attr=\"](baz)\">");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[foo \\s*<bar attr=\"\\]\\(baz\\)\">\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks22() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo][bar]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[bar]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks23() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[*foo\\!*][bar]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[bar]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*\\s*<em>\\s*foo!\\s*</em>\\s*\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks24() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo][BaR]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[bar]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks25() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[Толпой][Толпой] is a Russian word.");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[ТОЛПОЙ]: /url");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\">\\s*Толпой\\s*</a>\\s* is a Russian word\\.\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks26() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[Foo");
    text.append(BR);
    text.append("  bar]: /url");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[Baz][Foo bar]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\">\\s*Baz\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks27() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo] [bar]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[bar]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks28() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]");
    text.append(BR);
    text.append("[bar]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[bar]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks29() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]: /url1");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url2");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[bar][foo]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url1\">\\s*bar\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks30() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[bar][foo\\!]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo!]: /url");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[bar\\]\\[foo!\\]\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks31() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo][]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks32() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[*foo* bar][]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[*foo* bar]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*\\s*<em>\\s*foo\\s*</em>\\s* bar\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks33() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[Foo][]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*Foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks34() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo] ");
    text.append(BR);
    text.append("[]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks35() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks36() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[*foo* bar]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[*foo* bar]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*\\s*<em>\\s*foo\\s*</em>\\s* bar\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks37() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[[*foo* bar]]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[*foo* bar]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[\\s*<a href=\"/url\" title=\"title\">\\s*\\s*<em>\\s*foo\\s*</em>\\s* bar\\s*</a>\\s*\\]\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks38() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[Foo]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\" title=\"title\">\\s*Foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks39() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("\\[foo]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[foo\\]\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks40() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo*]: /url");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("*[foo*]");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\*\\s*<a href=\"/url\">\\s*foo\\*\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks41() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo`]: /url");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo`]`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[foo\\s*<code>\\s*\\]\\s*</code>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks42() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[[[foo]]]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[[[foo]]]: /url");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\">\\s*\\[\\[foo\\]\\]\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks43() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[[[foo]]]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[[[foo]]]: /url1");
    text.append(BR);
    text.append("[foo]: /url2");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url1\">\\s*\\[\\[foo\\]\\]\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks44() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[\\[foo]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[\\[foo]: /url");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url\">\\s*\\[foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks45() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo][bar]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url1");
    text.append(BR);
    text.append("[bar]: /url2");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url2\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks46() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo][bar][baz]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[baz]: /url");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[foo\\]\\s*<a href=\"/url\">\\s*bar\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks47() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo][bar][baz]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[baz]: /url1");
    text.append(BR);
    text.append("[bar]: /url2");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"/url2\">\\s*foo\\s*</a>\\s*\\s*<a href=\"/url1\">\\s*baz\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testLinks48() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("[foo][bar][baz]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[baz]: /url1");
    text.append(BR);
    text.append("[foo]: /url2");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\[foo\\]\\s*<a href=\"/url1\">\\s*bar\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![foo](/url \"title\")");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"/url\" alt=\"foo\" title=\"title\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![foo *bar*]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo *bar*]: train.jpg \"train & tracks\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"train\\.jpg\" alt=\"foo &lt;em&gt;bar&lt;/em&gt;\" title=\"train &amp; tracks\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![foo *bar*][]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo *bar*]: train.jpg \"train & tracks\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"train\\.jpg\" alt=\"foo &lt;em&gt;bar&lt;/em&gt;\" title=\"train &amp; tracks\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![foo *bar*][foobar]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[FOOBAR]: train.jpg \"train & tracks\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"train\\.jpg\" alt=\"foo &lt;em&gt;bar&lt;/em&gt;\" title=\"train &amp; tracks\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![foo](train.jpg)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"train\\.jpg\" alt=\"foo\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("My ![foo bar](/path/to/train.jpg  \"title\"   )");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*My \\s*<img src=\"/path/to/train\\.jpg\" alt=\"foo bar\" title=\"title\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![foo](<url>)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"url\" alt=\"foo\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![](/url)");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"/url\" alt=\"\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![foo] [bar]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[bar]: /url");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"/url\" alt=\"foo\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![foo] [bar]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[BAR]: /url");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"/url\" alt=\"foo\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![foo][]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"/url\" alt=\"foo\" title=\"title\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![*foo* bar][]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[*foo* bar]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"/url\" alt=\"&lt;em&gt;foo&lt;/em&gt; bar\" title=\"title\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![Foo][]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"/url\" alt=\"Foo\" title=\"title\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![foo] ");
    text.append(BR);
    text.append("[]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"/url\" alt=\"foo\" title=\"title\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages15() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![foo]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"/url\" alt=\"foo\" title=\"title\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages16() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![*foo* bar]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[*foo* bar]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"/url\" alt=\"&lt;em&gt;foo&lt;/em&gt; bar\" title=\"title\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages17() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![[foo]]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[[foo]]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"/url\" alt=\"\\[foo\\]\" title=\"title\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages18() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("![Foo]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<img src=\"/url\" alt=\"Foo\" title=\"title\" />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages19() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("\\!\\[foo]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*!\\[foo\\]\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testImages20() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("\\![foo]");
    text.append(BR);
    text.append("");
    text.append(BR);
    text.append("[foo]: /url \"title\"");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*!\\s*<a href=\"/url\" title=\"title\">\\s*foo\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<http://foo.bar.baz>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"http://foo\\.bar\\.baz\">\\s*http://foo\\.bar\\.baz\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<http://foo.bar.baz?q=hello&id=22&boolean>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"http://foo\\.bar\\.baz\\?q=hello&amp;id=22&amp;boolean\">\\s*http://foo\\.bar\\.baz\\?q=hello&amp;id=22&amp;boolean\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<irc://foo.bar:2233/baz>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"irc://foo\\.bar:2233/baz\">\\s*irc://foo\\.bar:2233/baz\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<MAILTO:FOO@BAR.BAZ>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"MAILTO:FOO@BAR\\.BAZ\">\\s*MAILTO:FOO@BAR\\.BAZ\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<http://foo.bar/baz bim>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&lt;http://foo\\.bar/baz bim&gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<foo@bar.example.com>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"mailto:foo@bar\\.example\\.com\">\\s*foo@bar\\.example\\.com\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<foo+special@Bar.baz-bar0.com>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"mailto:foo\\+special@Bar\\.baz-bar0\\.com\">\\s*foo\\+special@Bar\\.baz-bar0\\.com\\s*</a>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&lt;&gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<heck://bing.bong>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&lt;heck://bing\\.bong&gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("< http://foo.bar >");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&lt; http://foo\\.bar &gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<foo.bar.baz>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&lt;foo\\.bar\\.baz&gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<localhost:5001/foo>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&lt;localhost:5001/foo&gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("http://example.com");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*http://example\\.com\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testAutolinks14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo@bar.example.com");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo@bar\\.example\\.com\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a><bab><c2c>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a>\\s*\\s*<bab>\\s*\\s*<c2c>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a/><b2/>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a/>\\s*\\s*<b2/>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a  /><b2");
    text.append(BR);
    text.append("data=\"foo\" >");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a  />\\s*\\s*<b2\\s*");
    sb.append("data=\"foo\" >\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a foo=\"bar\" bam = 'baz <em>\"</em>'");
    text.append(BR);
    text.append("_boolean zoop:33=zoop:33 />");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a foo=\"bar\" bam = 'baz \\s*<em>\\s*\"\\s*</em>\\s*'\\s*");
    sb.append("_boolean zoop:33=zoop:33 />\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<33> <__>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&lt;33&gt; &lt;__&gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a h*#ref=\"hi\">");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&lt;a h\\*#ref=&quot;hi&quot;&gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a href=\"hi'> <a href=hi'>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&lt;a href=&quot;hi'&gt; &lt;a href=hi'&gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("< a><");
    text.append(BR);
    text.append("foo><bar/ >");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&lt; a&gt;&lt;\\s*");
    sb.append("foo&gt;&lt;bar/ &gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a href='bar'title=title>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&lt;a href='bar'title=title&gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("</a>");
    text.append(BR);
    text.append("</foo >");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*</a>\\s*\\s*");
    sb.append("\\s*</foo >\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("</a href=\"foo\">");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&lt;/a href=&quot;foo&quot;&gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml12() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo <!-- this is a");
    text.append(BR);
    text.append("comment - with hyphen -->");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo \\s*<!-- this is a\\s*");
    sb.append("comment - with hyphen -->\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml13() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo <!-- not a comment -- two hyphens -->");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo &lt;!-- not a comment -- two hyphens --&gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml14() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo <?php echo $a; ?>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo \\s*<\\?php echo \\$a; \\?>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml15() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo <!ELEMENT br EMPTY>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo \\s*<!ELEMENT br EMPTY>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml16() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo <![CDATA[>&<]]>");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo \\s*<!\\[CDATA\\[>\\s*&\\s*<\\]\\]>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml17() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a href=\"&ouml;\">");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"&ouml;\">\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml18() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a href=\"\\*\">");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"\\\\\\*\">\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testRawHtml19() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a href=\"\\\"\">");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*&lt;a href=&quot;&quot;&quot;&gt;\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHardLineBreaks01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo  ");
    text.append(BR);
    text.append("baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo\\s*<br />\\s*\\s*");
    sb.append("baz\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHardLineBreaks02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo\\");
    text.append(BR);
    text.append("baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo\\s*<br />\\s*\\s*");
    sb.append("baz\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHardLineBreaks03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo       ");
    text.append(BR);
    text.append("baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo\\s*<br />\\s*\\s*");
    sb.append("baz\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHardLineBreaks04() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo  ");
    text.append(BR);
    text.append("     bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo\\s*<br />\\s*\\s*");
    sb.append("bar\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHardLineBreaks05() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo\\");
    text.append(BR);
    text.append("     bar");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo\\s*<br />\\s*\\s*");
    sb.append("bar\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHardLineBreaks06() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo  ");
    text.append(BR);
    text.append("bar*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo\\s*<br />\\s*\\s*");
    sb.append("bar\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHardLineBreaks07() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("*foo\\");
    text.append(BR);
    text.append("bar*");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<em>\\s*foo\\s*<br />\\s*\\s*");
    sb.append("bar\\s*</em>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHardLineBreaks08() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("`code  ");
    text.append(BR);
    text.append("span`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*code span\\s*</code>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHardLineBreaks09() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("`code\\");
    text.append(BR);
    text.append("span`");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<code>\\s*code\\\\ span\\s*</code>\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHardLineBreaks10() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a href=\"foo  ");
    text.append(BR);
    text.append("bar\">");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"foo  \\s*");
    sb.append("bar\">\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testHardLineBreaks11() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("<a href=\"foo\\");
    text.append(BR);
    text.append("bar\">");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*\\s*<a href=\"foo\\\\\\s*");
    sb.append("bar\">\\s*\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSoftLineBreaks01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo");
    text.append(BR);
    text.append("baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo\\s*");
    sb.append("baz\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testSoftLineBreaks02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("foo ");
    text.append(BR);
    text.append(" baz");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*foo\\s*");
    sb.append("baz\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testStrings01() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("hello $.;'there");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*hello \\$\\.;'there\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testStrings02() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Foo χρῆν");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*Foo χρῆν\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }

  public void testStrings03() throws Exception {
    StringBuilder text = new StringBuilder();
    text.append("Multiple     spaces");
    String html = parser.toHtml(text.toString());
    TestUtil.println("HTML: " + html);
    StringBuilder sb = new StringBuilder();
    sb.append("\\s*<p>\\s*Multiple     spaces\\s*</p>\\s*\\s*");
    assertTrue(Pattern.compile(sb.toString(), Pattern.MULTILINE)
        .matcher(html).find());
  }
}