package tests;

import helpers.ReadXls;
import helpers.WriteResults;
import org.junit.Test;

import java.util.List;

public class SearchTest extends BeforeAfter {
    ReadXls reader = new ReadXls();
    WriteResults writer = new WriteResults();
    List<String[]> paramLst = reader.readXls();

    @Test
    public void testSearch() {

        driver.navigate().to("https://www.cian.ru");

        for (int i = 0; i < paramLst.size(); i++) {
            String action = paramLst.get(i)[0];
            String type_ob = paramLst.get(i)[1];
            String min_price = paramLst.get(i)[2];
            String max_price = paramLst.get(i)[3];
            String town = paramLst.get(i)[4];

            searchPage.chooseAction(action);
            searchPage.chooseObject(type_ob);
            searchPage.inputPrice(min_price, max_price);
            searchPage.inputTown(town);

            searchPage.getSearchButton().click();
            writer.writeResults(resultPage.checkPhotos(), i + 1, paramLst.get(i));
            resultPage.getLogo().click();
        }

    }


}
