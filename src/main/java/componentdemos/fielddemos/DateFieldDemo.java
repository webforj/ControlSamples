package componentdemos.fielddemos;

import java.time.LocalDate;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.field.DateField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class DateFieldDemo extends App {
	
	DateField departure = new DateField(LocalDate.now());

  @Override
  public void run() throws DwcjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    departure.setLabel("Departure Date:")
        .addClassName("date__input");

    window.add(departure);

  }
}