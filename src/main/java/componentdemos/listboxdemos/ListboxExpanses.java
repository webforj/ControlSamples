package componentdemos.listboxdemos;

import java.util.ArrayList;
import java.util.List;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.Expanse;
import org.dwcj.component.list.ListBox;
import org.dwcj.component.list.ListItem;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/listboxstyles/expanse_styles.css")
public class ListboxExpanses extends App {
	
	ListBox l1 = new ListBox();
	ListBox l2 = new ListBox();
	ListBox l3 = new ListBox();
	ListBox l4 = new ListBox();
	ListBox l5 = new ListBox();
			
  @Override
  public void run() throws DwcjException {
    Frame window = new Frame();
    window.addClassName("Frame");

    l1.setExpanse(Expanse.XSMALL);
    l2.setExpanse(Expanse.SMALL);
    l3.setExpanse(Expanse.MEDIUM);
    l4.setExpanse(Expanse.LARGE);
    l5.setExpanse(Expanse.XLARGE);

    List<ListItem> data = new ArrayList<>();
    data.add(new ListItem("Random Data1", "Random Data"));
    data.add(new ListItem("Random Data2", "Some Data"));
    data.add(new ListItem("Random Data3", "More Data"));
    data.add(new ListItem("Random Data4", "Test Data"));

    window.add(l1, l2, l3, l4, l5);

    l1.insert(data)
        .setLabel("Extra Small:");
    l2.insert(data)
        .setLabel("Small:");
    l3.insert(data)
        .setLabel("Medium:");
    l4.insert(data)
        .setLabel("Large");
    l5.insert(data)
        .setLabel("Extra Large:");
  }
}
