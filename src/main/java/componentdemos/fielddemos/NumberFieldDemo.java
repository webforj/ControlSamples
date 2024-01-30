package componentdemos.fielddemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.field.NumberField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class NumberFieldDemo extends App {
	
	 NumberField numField = new NumberField();

  @Override
  public void run() throws DwcjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    numField.addClassName("date__input");
    numField.setLabel("Quantity:");

    window.add(numField);
  }
}