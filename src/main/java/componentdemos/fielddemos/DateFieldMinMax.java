package componentdemos.fielddemos;

import java.time.LocalDate;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.field.DateField;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/fieldstyles/date_field_styles.css")
public class DateFieldMinMax extends App {
	
	 DateField departure = new DateField(LocalDate.now());
	 DateField returnField = new DateField(LocalDate.now().plusDays(1));

  @Override
  public void run() throws DwcjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    departure.setLabel("Departure Date:")
        .setMin(LocalDate.now())
        .addClassName("date__input");

    returnField.setLabel("Return Date:")
        .addClassName("date__input");

    window.add(departure, returnField);

    departure.onModify(e -> {
      returnField.setValue(DateField.fromDate(e.getText()).plusDays(1));
      returnField.setMin(DateField.fromDate(e.getText()));
    });
  }
}