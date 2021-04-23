package hw6.forms;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw6.entities.MetalsAndColors;

import java.util.ArrayList;


public class MetalsAndColorsForm extends Form<MetalsAndColors> {

    @Css("[name='custom_radio_odd']")
    public RadioButtons oddsRadioButtons;

    @Css("[name='custom_radio_even']")
    public RadioButtons evenRadioButtons;

    @FindBy(id="calculate-button")
    public Button calculateButton;

    @Css("#elements-checklist label")
    public JList<Label> elementsList;

    @XPath("//*[@id='colors']/div/button")
    public Button colorsDropdownButton;

    @XPath("//*[@id='colors']/select")
    public Dropdown colorsDropdown;

    @XPath("//*[@id='metals']/div/button")
    public Button metalsDropdownButton;

    @XPath("//*[@id='metals']/select")
    public Dropdown metalsDropdown;

    @XPath("//*[@id='vegetables']/div/button")
    public Button vegetablesDropdownButton;

    @JDropdown(root = "#salad-dropdown",
            value = "#g7",
            list = "li",
            expand = ".caret")
    public Dropdown vegetablesMenu;

    @FindBy(id="submit-button")
    public Button submitButton;

    public void prepareForm() {
        colorsDropdown.setAttribute("style", "");
        metalsDropdown.setAttribute("style", "");
        vegetablesMenu.expand();
        vegetablesMenu.select("Vegetables");
        vegetablesMenu.expand();
    }

    @Override
    public void submit(MetalsAndColors metalsAndColors) {
        oddsRadioButtons.select(metalsAndColors.summary.get(0).toString());
        evenRadioButtons.select(metalsAndColors.summary.get(1).toString());

        // I have to check selected element: when I try to select the element, that is already selected,
        // the dropdown menu won't hide and covers Submit button, so I can't click it
        if(!colorsDropdown.selected(metalsAndColors.color)) {
            colorsDropdownButton.click();
            colorsDropdown.select(metalsAndColors.color);
        }

        if(!metalsDropdown.selected(metalsAndColors.metals)) {
            metalsDropdownButton.click();
            metalsDropdown.select(metalsAndColors.metals);
        }

        this.selectCheckBoxesElements(metalsAndColors.elements);

        vegetablesMenu.expand();
        this.selectVegetablesDropdownCheckboxes(metalsAndColors.vegetables);

        calculateButton.click();
        submitButton.click();

        // Unselect the same checkboxes. Because elementsList.selected(label.getValue()) to check if
        // checkbox is already selected just doesn't work. Cleanup before next testData.
        this.selectCheckBoxesElements(metalsAndColors.elements);
        this.selectVegetablesDropdownCheckboxes(metalsAndColors.vegetables);
    }

    private void selectCheckBoxesElements(ArrayList<String> elements) {
        for(String elem : elements) {
            elementsList.select(elem);
        }
    }

    private void selectVegetablesDropdownCheckboxes(ArrayList<String> vegetables){
        for(String veg : vegetables) {
            vegetablesMenu.select(veg);
        }
    }

}
