package componentdemos.radiobuttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Expanse;
import org.dwcj.component.optioninput.RadioButton;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/radiobuttonstyles/radiobutton_styles.css")
public class RadioButtonSwitch extends App{
	
	RadioButton normalButton = new RadioButton("Normal RadioButton");
	RadioButton switchButton = RadioButton.Switch("Switch RadioButton");
	
  @Override
  public void run() throws DwcjException {
      Frame window = new Frame();
      window.addClassName("Frame");
      window.setStyle("flex-direction", "row");
      
      normalButton.setExpanse(Expanse.XLARGE);
      switchButton.setExpanse(Expanse.XLARGE);

      window.add(normalButton,switchButton);
  }
}
