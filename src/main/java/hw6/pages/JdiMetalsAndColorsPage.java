package hw6.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import hw6.entities.MetalsAndColorsFormTestData;
import hw6.forms.MetalsAndColorsForm;

public class JdiMetalsAndColorsPage extends WebPage {

    //@Css(".form")
    public MetalsAndColorsForm metalsAndColorsForm;


    public void submitTestDataToMetalsAndColorsForm(MetalsAndColorsFormTestData testDataEntity) {
        metalsAndColorsForm.submitWithTestData(testDataEntity);
    }

}
