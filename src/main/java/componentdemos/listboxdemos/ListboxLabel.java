package componentdemos.listboxdemos;

import java.util.HashMap;
import java.util.Map;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.concern.HasHorizontalAlignment;
import org.dwcj.component.window.Frame;
import org.dwcj.component.list.ListBox;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/listboxstyles/label_styles.css")
public class ListboxLabel extends App {
	
	ListBox l1 = new ListBox();
	
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");


    l1.add("Random Data1", "Random Data");
    l1.add("Random Data2", "Some Data");
    l1.add("Random Data3", "More Data");
    l1.add("Random Data4", "Test Data");

    window.add(l1);

    l1.setHorizontalAlignment(HasHorizontalAlignment.Alignment.RIGHT)
        .setLabel("Built-in Label for a list box!");
  }
}
