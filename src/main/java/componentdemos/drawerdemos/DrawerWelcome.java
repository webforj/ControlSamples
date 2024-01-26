package componentdemos.drawerdemos;

import org.dwcj.App;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Expanse;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.drawer.Drawer;
import org.dwcj.component.drawer.Drawer.Placement;
import org.dwcj.component.html.elements.Div;
import org.dwcj.component.html.elements.H1;
import org.dwcj.component.html.elements.H2;
import org.dwcj.component.html.elements.H4;
import org.dwcj.component.html.elements.Img;
import org.dwcj.component.html.elements.Strong;
import org.dwcj.component.layout.applayout.AppLayout;
import org.dwcj.component.layout.applayout.AppLayout.DrawerPlacement;
import org.dwcj.component.text.Label;
import org.dwcj.component.tabbedpane.TabbedPane;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

@InlineStyleSheet("context://css/drawerstyles/drawer_welcome.css")
public class DrawerWelcome extends App {
	
	Drawer welcomeDrawer;
	AppLayout demo = new AppLayout();

	Div header = new Div();
	Div drawer = new Div();
	Div iconButton = new Div();
	Div drawerLogo = new Div();
	
	Strong title = new Strong("DWCJ Application");	
	Button openWelcome = new Button("Open Welcome Page");
	TabbedPane drawerMenu = new TabbedPane();
	
	@Override
	public void run() throws DwcjException {
		Frame window = new Frame();
		window.add(demo);

		// Header
		iconButton.setHtml("<bbj-icon-button name='menu-2' data-drawer-toggle><bbj-icon-button>");

		header.add(iconButton, title);
		header.addClassName("bbj__toolbar-drawer");

		demo.addToHeader(header);
		demo.setHeaderReveal(true);

		demo.addToDrawer(drawer);
		drawer.addClassName("app-layout-drawer");
		demo.setDrawerPlacement(DrawerPlacement.LEFT);
		
		// Drawer's logo container and logo
		drawerLogo.addClassName("drawer__logo")
			.add(
			new Img("https://i.ibb.co/1n4n1Nh/logo.png\" alt=\"logo\" /></div></html>"));
		drawer.add(drawerLogo);
			
		// Drawer's Menu
		drawer.add(drawerMenu);

		drawerMenu.hideBody(true);
		drawerMenu.setBorderless(true);
		drawerMenu.setPlacement(TabbedPane.Placement.LEFT);

		// Adding tabs to drawer menu
		drawerMenu.addTab("<bbj-icon name='dashboard'></bbj-icon>      Dashboard");
		drawerMenu.addTab("<bbj-icon name='shopping-cart'></bbj-icon>  Orders");
		drawerMenu.addTab("<bbj-icon name='users'></bbj-icon>          Customers");
		drawerMenu.addTab("<bbj-icon name='box'></bbj-icon>            Products");
		drawerMenu.addTab("<bbj-icon name='files'></bbj-icon>          Documents");
		drawerMenu.addTab("<bbj-icon name='checklist'></bbj-icon>      Tasks");
		drawerMenu.addTab("<bbj-icon name='chart-dots-2'></bbj-icon>   Analytics");

		// Welcome Drawer

		welcomeDrawer = new Drawer();
		window.add(welcomeDrawer);
		welcomeDrawer
				.setPlacement(Placement.BOTTOM)
				.addClassName("welcome__drawer")
				.open();
		welcomeDrawer.add(new Img("""
				https://thumb9.shutterstock.com/mosaic_
				250/177370774/1312166426/stock-vector-handshake-heart-icon-stroke-outline-style
				-line-vector-isolate-on-white-background-1312166426.jpg
				"""));

		welcomeDrawer.add(new H2("Welcome to DWCJ"));
		welcomeDrawer.add(new Div("Lorem Ipsum is simply dummy text of the printing and typesetting industry"));
		welcomeDrawer.add(new Button("Get Started")
				.addClassName("welcome__drawer-content")
				.setTheme(ButtonTheme.PRIMARY)
				.setExpanse(Expanse.LARGE));

		// Content
		openWelcome.onClick( e -> welcomeDrawer.open());

		demo.addToContent(
				new H1("Application Title"),
				new H4("Application Content"),
				openWelcome);
	}
}