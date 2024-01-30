package componentdemos.fielddemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.field.PasswordField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class PasswordFieldDemo extends App {
	
	PasswordField passwordField = new PasswordField();

  @Override
  public void run() throws DwcjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    passwordField.addClassName("date__input");
    passwordField.setLabel("Enter your Password:");
    passwordField.setPlaceholder("Password");

    window.add(passwordField);
  }
}