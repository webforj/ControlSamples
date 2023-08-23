package componentdemos.checkboxdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.window.Frame;
import org.dwcj.component.TextPosition.Position;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.optioninput.CheckBox;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/checkboxstyles/text_styles.css")
public class CheckboxHorizontalText extends App {
  
  @Override
  public void run() throws DwcjException {
    Frame panel = new Frame();
    panel.addClassName("Frame");

    FlexLayout rightAligned = FlexLayout.create()
    .vertical()
    .build()
    .setStyle("width", "100px");
    
    FlexLayout leftAligned = FlexLayout.create()
    .vertical()
    .align().end()
    .build()
    .setStyle("width", "100px");

    rightAligned.add(
      new CheckBox("Daily", true),
      new CheckBox("Weekly"),
      new CheckBox("Bi-Weekly"),
      new CheckBox("Monthly"),
      new CheckBox("Annually")
    );
    
    leftAligned.add(
      new CheckBox("Daily", true).setTextPosition(Position.LEFT),
      new CheckBox("Weekly").setTextPosition(Position.LEFT),
      new CheckBox("Bi-Weekly").setTextPosition(Position.LEFT),
      new CheckBox("Monthly").setTextPosition(Position.LEFT),
      new CheckBox("Annually").setTextPosition(Position.LEFT)
    );

    panel.add(rightAligned, leftAligned);
  }
}