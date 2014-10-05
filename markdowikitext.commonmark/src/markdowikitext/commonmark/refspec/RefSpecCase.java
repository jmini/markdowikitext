package markdowikitext.commonmark.refspec;

/**
 * @author jbr
 */
public class RefSpecCase {
  protected static final String BR = System.getProperty("line.separator");

  private final String input;
  private final String output;

  public RefSpecCase(String input, String output) {
    super();
    this.input = input;
    this.output = output;
  }

  public String getInput() {
    return input;
  }

  public String getOutput() {
    return output;
  }
}
