package hw6.pages;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hw6.entities.MetalsAndColors;
import hw6.forms.MetalsAndColorsForm;

import java.util.List;


public class JdiMetalsAndColorsPage extends WebPage {

    private MetalsAndColorsForm metalsAndColorsForm;

    @XPath("//section[2]/div[2]/div/ul/li")
    public JList<Text> resultsList;

    public void submitMetalsAndColorsForm(MetalsAndColors metalsAndColors) {
        metalsAndColorsForm.submit(metalsAndColors);
    }

    public List<String> getResultsInfo() {
        return resultsList.values();
    }

    public void prepareMetalsAndColorsForm() {
        metalsAndColorsForm.prepareForm();
    }

}
