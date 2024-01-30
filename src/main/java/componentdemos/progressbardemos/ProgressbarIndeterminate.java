package componentdemos.progressbardemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/indeterminate_styles.css")
public class ProgressbarIndeterminate extends App {

  ProgressBar pb = new ProgressBar();

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();

    window.addClassName("Frame").add(pb);

    pb.setIndeterminate(true)
        .addClassName("progress__bar")
        .setText("Syncing Files");
  }
}
