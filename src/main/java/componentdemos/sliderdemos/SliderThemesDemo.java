package componentdemos.sliderdemos;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.text.Label;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.component.slider.Slider;

@InlineStyleSheet("context://css/sliderstyles/theme_styles.css")
public class SliderThemesDemo extends App {
  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    Slider sl1 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.DEFAULT);

    Slider sl2 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.DANGER);

    Slider sl3 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.GRAY);

    Slider sl4 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.INFO);

    Slider sl5 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.SUCCESS);

    Slider sl6 = new Slider().setMaximum(100)
        .setMinimum(0)
        .setValue(50)
        .setTheme(Slider.Theme.WARNING);

    window.add(
        new Label("<html><b>DEFAULT</b></html>"), sl1,
        new Label("<html><b>DANGER</b></html>"), sl2,
        new Label("<html><b>GRAY</b></html>"), sl3,
        new Label("<html><b>INFO</b></html>"), sl4,
        new Label("<html><b>SUCCESS</b></html>"), sl5,
        new Label("<html><b>WARNING</b></html>"), sl6);
  }
}
