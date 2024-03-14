package componentdemos.textboxdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.component.field.TextField;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/textboxstyles/text_box_styles.css")
public class TextBoxSpellcheck extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    TextField t1 = new TextField().setAttribute("spellcheck", "true")
        .setAttribute("placeholder", "Enter misspelled text");

    window.add(t1);
  }
}
