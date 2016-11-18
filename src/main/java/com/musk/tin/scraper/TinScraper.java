package com.musk.tin.scraper;

import com.musk.tin.model.TinDetails;
import com.musk.tin.upload.DropBoxUpload;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

/**
 * This is scraper class for scrap a tin details;
 * Created by dhiren on 17/11/16.
 * @author dhiren
 * @since 17-11-2016
 */
public class TinScraper {

    private final String url;

    private final WebDriver WEB_DRIVER;

    public TinScraper()
    {
        this.url = "http://www.tinxsys.com/TinxsysInternetWeb/dealerControllerServlet";
        DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
        String[] args = { "--web-security=no", "--ignore-ssl-errors=yes",
                "--ssl-protocol=tlsv1" };
        capabilities.setCapability(
                PhantomJSDriverService.PHANTOMJS_CLI_ARGS, args);
        String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
        capabilities.setCapability(
                PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX
                        + "userAgent", userAgent);
        this.WEB_DRIVER = new PhantomJSDriver(capabilities);
    }

    public boolean scrape(String tinNumber) throws Exception
    {
        String url = this.url+"?tinNumber="+tinNumber+"&searchBy=TIN";
        WEB_DRIVER.navigate().to(url);
        List<WebElement>tableData = WEB_DRIVER.findElements(By.tagName("table")).get(1).findElements(By.xpath("//tr//td"));
        int i =0;
        TinDetails tinDetails = new TinDetails(cleanText(tableData.get(7).getText()), cleanText(tableData.get(9).getText()), cleanText(tableData.get(11).getText()), cleanText(tableData.get(13).getText()), cleanText(tableData.get(15).getText()), cleanText(tableData.get(17).getText()),tableData.get(19).getText().replaceAll("\\r|\\n", " ").trim(),cleanText(tableData.get(21).getText()), tableData.get(23).getText().replaceAll("\\r|\\n", " ").trim());
        DropBoxUpload dropBoxUpload = new DropBoxUpload(tinDetails);
        return dropBoxUpload.isUpload();
    }

    private String cleanText(String str)
    {
        str = str.replaceAll("\\r|\\n", " ");
        return  str.replaceAll("[^\\w\\s]"," ").trim();
    }
}