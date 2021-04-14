package hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw6.entities.MetalsAndColorsFormTestData;


public class MetalsAndColorsForm extends Form {

    @Css("[name='custom_radio_odd']")
    public RadioButtons oddsRadioButtons;

    @Css("[name='custom_radio_even']")
    public RadioButtons evenRadioButtons;

    @FindBy(id="calculate-button")
    public Button calculateButton;

    @XPath("//*[@id='elements-checklist']/p[position()<5]/input")
    public Checklist checkListElements;

    @XPath("//*[@id='colors']/div/button")
    public Button colorsDropdownButton;

    @XPath("//*[@id='colors']/select")
    public Dropdown colorsDropdown;

    @XPath("//*[@id='metals']/div/button")
    public Button metalsDropdownButton;

    @XPath("//*[@id='metals']/select")
    public Dropdown metalsDropdown; // <select> tag

    @XPath("//*[@id='vegetables']/div/button")
    public Button vegetablesDropdownButton;

    //@XPath("//*[@class='uui-form-element blue']")
    @XPath("//*[@id='salad-dropdown']/ul/li[position()<5]/a/input")
    public Checklist vegetablesMenu;

    @FindBy(id="submit-button")
    public Button submitButton;


    public void submitWithTestData(MetalsAndColorsFormTestData testData) {
        oddsRadioButtons.select(testData.summary.get(0).toString());
        evenRadioButtons.select(testData.summary.get(1).toString());
        calculateButton.click();

        // I have to check selected element: when I try to select the element, that is already selected,
        // the dropdown menu won't hide and covers Submit button, so I can't click it
        colorsDropdown.setAttribute("style", "");   // move it!
        if(!colorsDropdown.selected(testData.color)) {
            colorsDropdownButton.click();
            colorsDropdown.select(testData.color);
        }

        metalsDropdown.setAttribute("style", "");   // move it!
        if(!metalsDropdown.selected(testData.metals)) {
            metalsDropdownButton.click();
            metalsDropdown.select(testData.metals);
        }


        checkListElements.uncheckAll();
        System.out.println(checkListElements.values());
        for(String elem : testData.elements) {
            checkListElements.select(elem);
        }

        /*vegetablesDropdownButton.click();
        vegetablesMenu.uncheckAll();

        for(String veg : testData.vegetables) {
            vegetablesMenu.check(veg);
        }
*/
        submitButton.click();

    }

}
