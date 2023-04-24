package layout_demos.container;

import java.util.ArrayList;
import java.util.HashMap;

import org.dwcj.App;
import org.dwcj.addons.code.Code;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.choicebox.ChoiceBox;
import org.dwcj.component.choicebox.event.ChoiceBoxSelectEvent;
import org.dwcj.component.spinnernumberfield.SpinnerNumberField;
import org.dwcj.component.flexlayout.FlexAlignment;
import org.dwcj.component.flexlayout.FlexContentAlignment;
import org.dwcj.component.flexlayout.FlexDirection;
import org.dwcj.component.flexlayout.FlexJustifyContent;
import org.dwcj.component.flexlayout.FlexLayout;
import org.dwcj.component.flexlayout.FlexWrap;
import org.dwcj.component.numberfield.event.NumberFieldModifyEvent;
import org.dwcj.component.window.Frame;
import org.dwcj.component.window.Panel;
import org.dwcj.exceptions.DwcjException;

import layout_demos.helper.Box;

@InlineStyleSheet("context://css/flexstyles/container_styles.css")
public class ContainerDemo extends App{

  SpinnerNumberField spinner;
  
  FlexLayout boxLayout;
  ArrayList<Box> boxes;
  float numBoxes;

  String javaCode;
  Code codeWindow;
  HashMap<String, String> codeSnippetBuilder;

  @Override
  public void run() throws DwcjException{
    
    Frame page = new Frame().addClassName("app__frame");

    FlexLayout mainLayout = FlexLayout.create()
    .horizontal()
    .build();
    
    boxLayout = FlexLayout.create()
    .horizontal()
    .justify().start()
    .align().stretch()
    .contentAlign().normal()
    .wrap().nowrap()
    .build()
    .addClassName("button__container");
    
    
    FlexLayout flexContainerOptions = FlexLayout.create()
    .vertical()
    .build()
    .addClassName("flex__options");
    
    
    spinner = new SpinnerNumberField();
    spinner.setAttribute("label", "Number of Boxes");
    spinner.setStyle("width", "200px");
    spinner.onEditModify(this::spinnerChange);
    spinner.setText("1");
    
    boxes = new ArrayList<>();
    numBoxes = 0;
    addBox(1);
    
    flexContainerOptions.add(spinner);
    
    mainLayout.add(flexContainerOptions, boxLayout);
    page.add(mainLayout);

    ChoiceBox directions = new ChoiceBox().onSelect(this::selectDirection);
    directions.setAttribute("label", "Direction Options");
    for(FlexDirection justify : FlexDirection.values()){
      String label = justify.getValue();
      directions.addItem(
        "." + justify.toString()
          .toLowerCase() + "()", 
        label.substring(0, 1)
          .toUpperCase() + label
          .substring(1)
          );
      }
    directions.selectIndex(0);
    flexContainerOptions.add(directions);

    ChoiceBox justifications = new ChoiceBox().onSelect(this::selectJustification);
    justifications.setAttribute("label", "Justification Options");
    for(FlexJustifyContent justify : FlexJustifyContent.values()){
      String label = justify.getValue().replaceAll("^(.+?)-", "");
      justifications.addItem(".justify()." + justify.toString().toLowerCase().replaceAll("^(.+?)-", "") + "()", label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    justifications.selectIndex(0);
    flexContainerOptions.add(justifications);

    ChoiceBox alignments = new ChoiceBox().onSelect(this::selectAlignment);
    alignments.setAttribute("label", "Alignment Options");
    for(FlexAlignment justify : FlexAlignment.values()){
      String label = justify.getValue().replaceAll("^(.+?)-", "");
      alignments.addItem(".align()." + justify.toString().toLowerCase().replaceAll("^(.+?)-", "") + "()", label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    alignments.selectIndex(0);
    flexContainerOptions.add(alignments);

    ChoiceBox contentAlignments = new ChoiceBox().onSelect(this::selectAlignContent);
    contentAlignments.setAttribute("label", "Content-Alignment Options");
    for(FlexContentAlignment justify : FlexContentAlignment.values()){
      String label = justify.getValue().replaceAll("^(.+?)-", "");
      contentAlignments.addItem(".contentAlign()." + justify.toString().toLowerCase().replaceAll("^(.+?)-", "") + "()", label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    contentAlignments.selectIndex(0);
    flexContainerOptions.add(contentAlignments);

    ChoiceBox wraps = new ChoiceBox().onSelect(this::selectWrap);
    wraps.setAttribute("label", "Wrap Options");
    for(FlexWrap justify : FlexWrap.values()){
      String label = justify.getValue().replaceAll("^(.+?)-", "");
      wraps.addItem(".wrap()." + justify.toString().toLowerCase().replaceAll("^(.+?)-", "") + "()", label.substring(0, 1).toUpperCase() + label.substring(1));
    }
    wraps.selectIndex(0);
    flexContainerOptions.add(wraps);
  
    Panel flexCode = new Panel().addClassName("code__block");
      
    page.add(flexCode);
    
    codeWindow = new Code();
    flexCode.add(codeWindow);
    codeWindow.setLanguage("java");

    createStrings();
    updateCode();
  }
  
  private void createStrings(){
    codeSnippetBuilder = new HashMap<>();
    codeSnippetBuilder.put("FlexDirection", ".horizontal() \n");
    codeSnippetBuilder.put("FlexJustifyContent", "");
    codeSnippetBuilder.put("FlexAlignment", "");
    codeSnippetBuilder.put("FlexContentAlignment", "");
    codeSnippetBuilder.put("FlexWrap", "");
  }
  
  private void updateCode(){
    javaCode = "FlexLayout boxLayout = FlexLayout.create(buttons) \n"+
    codeSnippetBuilder.get("FlexDirection") +
    codeSnippetBuilder.get("FlexJustifyContent") +
    codeSnippetBuilder.get("FlexAlignment") +
    codeSnippetBuilder.get("FlexContentAlignment") +
    codeSnippetBuilder.get("FlexWrap");
    codeWindow.setText(javaCode);
  }

  private void spinnerChange(NumberFieldModifyEvent ev){
    App.consoleLog(ev.getControl().getText());
    if(ev.getControl().getText().isEmpty() || Integer.valueOf(ev.getControl().getText()) < 1){
      ev.getControl().setText("1");
    }
    if(Integer.valueOf(ev.getControl().getText()) > numBoxes){
      addBox(Integer.valueOf(ev.getControl().getText()));
    }
    else if(Integer.valueOf(ev.getControl().getText()) < numBoxes){
      removeBox(Integer.valueOf(ev.getControl().getText()));
    }
  }

  private void addBox(int newNum){
    while(newNum > numBoxes){
      numBoxes++;
      String hue = String.valueOf((360/10) * (int)numBoxes);
      Box newBox = new Box((int) numBoxes);
      newBox.setStyle("background", "hsla(" + String.valueOf(hue) + ", 50%, 75%, 0.25)");
      newBox.setStyle("border", "2px solid " + "hsl(" + String.valueOf(hue) + ", 50%, 35%)");
      newBox.setStyle("color", "hsl(" + String.valueOf(hue) + ", 50%, 25%)");
      boxes.add(newBox);
      boxLayout.add(newBox);
    }
  }

  private void removeBox(int newNum){
    while(newNum < numBoxes){
      boxes.get((int)numBoxes-1).destroy();
      boxes.remove((int)numBoxes-1);
      numBoxes--;
    }
  }

  private void selectDirection(ChoiceBoxSelectEvent ev){
    boxLayout.setDirection(FlexDirection.fromValue(ev.getControl().getSelectedItem().getValue()));
    switch(ev.getControl().getSelectedItem().getKey().toString()){
      case ".row-reverse()": codeSnippetBuilder.put("FlexDirection", ".horizontalReverse()");
      break;
      case ".column()": codeSnippetBuilder.put("FlexDirection", ".vertical()");
      break;
      case ".column-reverse()": codeSnippetBuilder.put("FlexDirection", ".verticalReverse()");
      break;
      default: codeSnippetBuilder.put("FlexDirection", ".horizontal()");
                  break;
    }
    updateCode();
  }
  
  private void selectJustification(ChoiceBoxSelectEvent ev){
    boxLayout.setJustifyContent(FlexJustifyContent.fromValue(ev.getControl().getSelectedItem().getValue()));
    if(ev.getControl().getSelectedItem().getKey().toString().equals(".justify().start()")){
      codeSnippetBuilder.put("FlexJustifyContent", "");
    }
    else{
      codeSnippetBuilder.put("FlexJustifyContent", ev.getControl().getSelectedItem().getKey().toString());
    }
    updateCode();
  }

  private void selectAlignment(ChoiceBoxSelectEvent ev){
    boxLayout.setAlignment(FlexAlignment.fromValue(ev.getControl().getSelectedItem().getValue()));
    if(ev.getControl().getSelectedItem().getKey().toString().equals(".align().stretch()")){
      codeSnippetBuilder.put("FlexAlignment", "");
    }
    else{
      codeSnippetBuilder.put("FlexAlignment", ev.getControl().getSelectedItem().getKey().toString());
    }
    updateCode();
  }

  private void selectAlignContent(ChoiceBoxSelectEvent ev){
    boxLayout.setAlignContent(FlexContentAlignment.fromValue(ev.getControl().getSelectedItem().getValue()));
    if(ev.getControl().getSelectedItem().getKey().toString().equals(".contentAlign().normal()")){
      codeSnippetBuilder.put("FlexContentAlignment", "");
    }
    else{
      codeSnippetBuilder.put("FlexContentAlignment", ev.getControl().getSelectedItem().getKey().toString());
    }
    updateCode();
  }

  private void selectWrap(ChoiceBoxSelectEvent ev){
    App.consoleLog(ev.getControl().getSelectedItem().getKey().toString());
    if(ev.getControl().getSelectedItem().getKey().toString().equals(".wrap().nowrap()")){
      boxLayout.setWrap(FlexWrap.fromValue(ev.getControl().getSelectedItem().getValue()));
      codeSnippetBuilder.put("FlexWrap", "");
    }
    else if(ev.getControl().getSelectedItem().getKey().toString().equals(".wrap().reverse()")){
      boxLayout.setWrap(FlexWrap.WRAP_REVERSE);
      codeSnippetBuilder.put("FlexWrap", ev.getControl().getSelectedItem().getKey().toString());
    }
    else{
      codeSnippetBuilder.put("FlexWrap", ev.getControl().getSelectedItem().getKey().toString());
    }
    updateCode();
  }
}
