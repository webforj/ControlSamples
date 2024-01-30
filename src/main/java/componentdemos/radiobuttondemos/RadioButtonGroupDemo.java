package componentdemos.radiobuttondemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.optioninput.RadioButton;
import org.dwcj.component.optioninput.RadioButtonGroup;

@InlineStyleSheet("context://css/radiobuttonstyles/radiobutton_styles.css")
public class RadioButtonGroupDemo extends App{
	

    RadioButton sAgree = new RadioButton("Strongly Agree");
    RadioButton agree = new RadioButton("Agree");
    RadioButton neutral = new RadioButton("Neutral");
    RadioButton disagree = new RadioButton("Disagree");
    RadioButton sDisagree = new RadioButton("Strongly Disagree");

    RadioButtonGroup group = new RadioButtonGroup(sDisagree, disagree, neutral, agree, sAgree);

    @Override
    public void run() throws DwcjException {

        Frame window = new Frame();
        window.addClassName("frame");

        FlexLayout layout = FlexLayout.create(group)
        .vertical()
        .wrap().wrap()
        .build()
        .addClassName("layout");
       
        window.add(layout);
    }
}
