  package componentdemos.fielddemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.field.DateTimeField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class DateTimeFieldDemo extends App {
	
	 DateTimeField departure = new DateTimeField();

  @Override
  public void run() throws DwcjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    departure.setLabel("Departure Date and Time:")
        .addClassName("date__input");

    window.add(departure);

  }
}