package util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Util {

    /**
     * This method allows to check the presence of text(name) in description film
     *
     * @param elements - Collection of description films
     * @param name     - text for finding
     */
    private static boolean compareDescriptionWithName(ElementsCollection elements, String name) {

        boolean isContains = false;
        int filmNumber = 0;

        for (SelenideElement element : elements) {
            isContains = element.getText().contains(name);
            System.out.println(element.getText());
            if (isContains == false) {
                System.err.println("-- Description Element - '" + element.getText()+ "' on position - " + filmNumber + " is not correct! ");
                return false;
            }
            filmNumber += 1;
        }
        return isContains;
    }


    /**
     * This method allows to get elements collection and implements iteration all pages
     *
     * @param elements              - Collection of description films
     * @param genre                 - Text for comparing
     * @param nextPageButtonElement - Go to next page element
     */
    public static boolean checkTextOnAllPages(ElementsCollection elements, String genre, SelenideElement nextPageButtonElement) {

        boolean assertResult;

        while (true) {
            assertResult = compareDescriptionWithName(elements, genre);

            if (!nextPageButtonElement.is(Condition.visible)) {
                break;
            }
            nextPageButtonElement.click();
        }
        return assertResult;
    }

    public static void waitUntilLoadingDisappears() {
        $("div[class*='loading']").waitUntil(Condition.disappear, 6000);
    }
}
