package componentdemos.radiobuttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.concern.HasTextPosition.Position;
import org.dwcj.component.optioninput.CheckBox;
import org.dwcj.component.optioninput.RadioButton;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/radiobuttonstyles/radiobutton_styles.css")
public class RadioButtonText extends App{
	
	 RadioButton buttonRight = new RadioButton("Right aligned (default)");
	 RadioButton buttonLeft = new RadioButton("Left aligned");
	 
  @Override
  public void run() throws DwcjException {
      Frame window = new Frame();
      window.addClassName("Frame");
      buttonLeft.setTextPosition(Position.LEFT);
      window.add(buttonRight, buttonLeft, new CheckBox("CheckBox"));
  }
}
