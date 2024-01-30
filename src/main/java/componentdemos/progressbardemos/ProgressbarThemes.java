package componentdemos.progressbardemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;
import org.dwcj.component.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/theme_styles.css")
public class ProgressbarThemes extends App {
	
    ProgressBar pb1 = new ProgressBar();
    ProgressBar pb2 = new ProgressBar();
    ProgressBar pb3 = new ProgressBar();
    ProgressBar pb4 = new ProgressBar();
    ProgressBar pb5 = new ProgressBar();
    ProgressBar pb6 = new ProgressBar();
    
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    window.add(pb1, pb2, pb3, pb4, pb5, pb6);

    pb1.setAttribute("theme", "default")
        .setMaximum(100)
        .setValue(80)
        .setText("DEFAULT");

    pb2.setAttribute("theme", "danger")
        .setMaximum(100)
        .setValue(70)
        .setText("DANGER");

    pb3.setAttribute("theme", "gray")
        .setMaximum(100)
        .setValue(60)
        .setText("GRAY");

    pb4.setAttribute("theme", "info")
        .setMaximum(100)
        .setValue(50)
        .setText("INFO");

    pb5.setAttribute("theme", "success")
        .setMaximum(100)
        .setValue(30)
        .setText("SUCCESS");

    pb6.setAttribute("theme", "warning")
        .setMaximum(100)
        .setValue(20)
        .setText("WARNING");
  }
}
