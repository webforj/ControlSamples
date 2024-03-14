package layout_demos.applayout;

import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Strong;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.layout.applayout.AppLayout.DrawerPlacement;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@InlineStyleSheet("context://css/applayoutstyles/applayout_mobile.css")
public class AppLayoutMobile extends App {

  AppLayout demo = new AppLayout();
  Div contentLabel = new Div();
  Div header = new Div();

  @Override
  public void run() throws WebforjException {
    Frame window = new Frame();
    window.add(demo);

    // Header
    Div logo = new Div();
		logo.addClassName("dwc-logo")
    .add(new Img("https://i.ibb.co/1n4n1Nh/logo.png", "logo"));
    Strong title = new Strong("DWCJ Application");

    header.add(logo, title);
    header.addClassName("dwc-toolbar");

    demo.addToHeader(header);
    demo.setHeaderReveal(true);
    demo.setDrawerPlacement(DrawerPlacement.HIDDEN);

    // Content
    demo.addToContent(
        new H1("Application Title"),
        this.contentLabel);
        for (int i = 0; i < 5; i++) {
          Div content = new Div().addClassName("card");
          content.add(
                new H2("What is Lorem Ipsum " + i + "?"),
                new Paragraph("Lorem Ipsum is simply dummy text of the printing and typesetting" +
                  "industry. Lorem Ipsum has been the industry's standard dummy text" +
                  "ever since the 1500s when an unknown printer took a galley of type" +
                  "and scrambled it to make a type specimen book. It has survived not" +
                  "only five centuries, but also the leap into electronic" +
                  "typesetting, remaining essentially unchanged. It was popularized" +
                  "in the 1960s with the release of Letraset sheets containing Lorem" +
                  "Ipsum passages, and more recently with desktop publishing software" +
                  "like Aldus PageMaker including versions of Lorem Ipsum.")
          );
          demo.addToContent(content);
    }

    TabbedPane footerMenu = new TabbedPane();
    demo.addToFooter(footerMenu);
    demo.setFooterReveal(true);

    footerMenu.hideBody(true);
    footerMenu.setBorderless(true);
    footerMenu.setPlacement(TabbedPane.Placement.BOTTOM);
    footerMenu.setAlignment(TabbedPane.Alignment.STRETCH);

    // Adding tabs to drawer menu
    footerMenu.addTab("<dwc-icon name='dashboard'></dwc-icon>");
    footerMenu.addTab("<dwc-icon name='shopping-cart'></dwc-icon>");
    footerMenu.addTab("<dwc-icon name='users'></dwc-icon>");
    footerMenu.addTab("<dwc-icon name='box'></dwc-icon>");
    footerMenu.addTab("<dwc-icon name='files'></dwc-icon>");
  }

}
