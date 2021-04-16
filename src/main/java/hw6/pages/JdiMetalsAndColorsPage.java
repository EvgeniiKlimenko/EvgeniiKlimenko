package hw6.pages;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hw6.entities.MetalsAndColorsFormTestData;
import hw6.forms.MetalsAndColorsForm;

import java.util.List;


public class JdiMetalsAndColorsPage extends WebPage {

    // no locator
    private MetalsAndColorsForm metalsAndColorsForm;

    @XPath("//*[@id='mCSB_2_container']/section[2]/div[2]/div/ul/li")
    public JList<Text> resultsList;



    public void submitTestDataToMetalsAndColorsForm(MetalsAndColorsFormTestData testDataEntity) {
        metalsAndColorsForm.submitWithTestData(testDataEntity);
    }

    public List<String> getResultsInfo() {
        return resultsList.values();
    }

    public void prepareMetalsAndColorsForm() {
        metalsAndColorsForm.prepareForm();
    }

}
