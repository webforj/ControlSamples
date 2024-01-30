package componentdemos.fielddemos;

import java.awt.Color;
import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.event.ModifyEvent;
import org.dwcj.component.field.ColorField;
import org.dwcj.component.layout.flexlayout.FlexLayout;
import org.dwcj.component.window.Frame;
import org.dwcj.component.html.elements.Div;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/fieldstyles/color_field_styles.css")
public class ColorFieldDemo extends App {

  ColorField colorField= new ColorField();
  Color[] tetradic = new Color[4];
  Div[] colors = new Div[4];
  Div title = new Div("Tetradic complementary colors:");

  @Override
  public void run() throws DwcjException {

    Frame window = new Frame();
    window.addClassName("main__window");

    colorField.addClassName("color__field")
        .setLabel("Choose a color:")
        .onModify(this::tetradicColor);

    for (int i = 0; i <= 3; i++) {
      colors[i] = new Div();
          colors[i].addClassName("color__panel");
    }

    FlexLayout colorDisplay = FlexLayout.create(colors)
        .horizontal()
        .justify().center()
        .align().center()
        .build()
        .addClassName("display__panel");
    colorDisplay.setSpacing("20px");


    colorField.setValue(Color.RED);
    tetradicColor(null);

    window.add(colorField, title, colorDisplay);
  }

  private void tetradicColor(ModifyEvent e) {
    Color selected = colorField.getValue();
    setBackgroundColor(colors[0], selected);
    int baseHue = getHue(selected);
    for (int i = 1; i <= 3; i++) {
      int hue = (baseHue + i * 60) % 360;
      setBackgroundColor(colors[i], Color.getHSBColor(hue / 360.0f, getSaturation(selected), getBrightness(selected)));
    }
  }

  private void setBackgroundColor(Div colorPanel, Color color) {
    colorPanel.setStyle("background-color", "rgb(" + String.valueOf(color.getRed()) +
        "," + String.valueOf(color.getGreen()) +
        "," + String.valueOf(color.getBlue()) +
        ")");
  }

  private static int getHue(Color color) {
    float[] hsbValues = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
    return (int) (hsbValues[0] * 360);
  }

  private static float getSaturation(Color color) {
    float[] hsbValues = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
    return hsbValues[1];
  }

  private static float getBrightness(Color color) {
    float[] hsbValues = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
    return hsbValues[2];
  }
}