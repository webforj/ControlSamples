package componentdemos.radiobuttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.optioninput.RadioButton;
import org.dwcj.component.optioninput.RadioButton.Activation;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/radiobuttonstyles/radiobutton_styles.css")
public class RadioButtonActivation extends App{
	
	RadioButton autoActivateOne = new RadioButton("Auto Activated");
	RadioButton autoActivateTwo = new RadioButton("Auto Activated");
	RadioButton manualActivateOne = new RadioButton("Manually Activated");
    RadioButton manualActivateTwo = new RadioButton("Manually Activated");
	
  @Override
  public void run() throws DwcjException {
      Frame window = new Frame();
      window.addClassName("Frame");

      autoActivateOne.setActivation(Activation.AUTO)
        .focus();
   
      autoActivateTwo.setActivation(Activation.AUTO);
     
      window.add(autoActivateOne, autoActivateTwo, manualActivateOne, manualActivateTwo);
  }
}
