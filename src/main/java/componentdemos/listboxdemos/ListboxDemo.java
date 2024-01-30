package componentdemos.listboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.list.ListBox;
import org.dwcj.component.list.MultipleSelectableList.SelectionMode;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/listboxstyles/listbox_demo.css")
public class ListboxDemo extends App {
	
	ListBox listBox = new ListBox();

    @Override
    public void run() throws DwcjException {

        Frame window = new Frame();
        window.addClassName("frame");

        window.add(listBox);

        listBox.add("Financial Reports", "Financial Reports");
        listBox.add("Sales and Marketing Reports", "Sales and Marketing Reports");
        listBox.add("Operational Reports", "Operational Reports");
        listBox.add("Human Resources Reports", "Human Resources Reports");
        listBox.add("Compliance Reports", "Compliance Reports");

        listBox.setLabel("Select Desired Report Type(s)");
        listBox.setSelectionMode(SelectionMode.MULTIPLE);
    }
}
