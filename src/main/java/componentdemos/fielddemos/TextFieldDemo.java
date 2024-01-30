package componentdemos.fielddemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.field.TextField;
import org.dwcj.component.field.TextField.Type;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class TextFieldDemo extends App {
	
	 TextField emailField = new TextField();
	 TextField searchField = new TextField();
	 TextField telField = new TextField();
	 TextField textField = new TextField();
	 TextField urlField = new TextField();

  @Override
  public void run() throws DwcjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    emailField.setType(Type.EMAIL);
    searchField.setType(Type.SEARCH);
    telField.setType(Type.TEL);
    textField.setType(Type.TEXT);
    urlField.setType(Type.URL);

    window.add(emailField, searchField, telField, textField, urlField);
  }
}