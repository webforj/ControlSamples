package componentdemos.progressbardemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

import org.dwcj.component.progressbar.ProgressBar;

@InlineStyleSheet("context://css/progressbarstyles/demo_styles.css")
public class ProgressbarDemo extends App {

    ProgressBar pb = new ProgressBar();

    @Override
    public void run() throws DwcjException {

        Frame window = new Frame();
        window.addClassName("Frame");
        window.add(pb);
        pb.addClassName("progress__bar");
        pb.setMaximum(100);
        pb.setAttribute("indeterminate", "true");
    }

}
