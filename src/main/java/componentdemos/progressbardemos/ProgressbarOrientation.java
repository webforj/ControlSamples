package componentdemos.progressbardemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

import org.dwcj.component.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/orientation_styles.css")
public class ProgressbarOrientation extends App {

  ProgressBar pb = new ProgressBar().addClassName("barVt");
  ProgressBar pb2 = new ProgressBar().addClassName("barHz");

  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    window.add(pb2, pb);

    pb.setAttribute("orientation", "vertical")
        .setValue(75)
        .setMaximum(100);

    pb2.setValue(75)
        .setMaximum(100);
  }
}
