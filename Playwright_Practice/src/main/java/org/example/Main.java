package org.example;

import com.microsoft.playwright.*;

public class Main {
public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.setViewportSize(1920, 1080);

        // Navigate to Amazon
        page.navigate("https://www.amazon.com/");
        page.waitForLoadState();

        // Search for a product
        page.fill("input[id='twotabsearchtextbox']", "PlayStation 5");
        page.press("input[id='twotabsearchtextbox']", "Enter");
        page.waitForLoadState();

        page.waitForSelector("");
        // Click on the search result
        page.click("#search > div.s-desktop-width-max.s-desktop-content.s-wide-grid-style-t1.s-opposite-dir.s-wide-grid-style.sg-row > div.sg-col-20-of-24.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span.rush-component.s-latency-cf-section > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(6) > div > div > div > div > div > div.sg-col.sg-col-4-of-12.sg-col-8-of-16.sg-col-12-of-20.sg-col-12-of-24.s-list-col-right > div > div > div.a-section.a-spacing-none.puis-padding-right-small.s-title-instructions-style > h2 > a > span");
        // Above selector will work often
        page.waitForLoadState();

        // Print the title of the product
        String productTitle = page.innerText("span[id='productTitle']");
        System.out.println("Product Title: " + productTitle);

        page.click("input[id='buy-now-button']");
        page.waitForLoadState();
        //Username
        page.fill("input[type='email']","typeyour0@email.com");
        page.click("input[id='continue']");
        page.waitForLoadState();
        //Password
        page.fill("input[id='password']","yoUrPasSword");
        page.click("input[id='signInSubmit']");
        page.waitForLoadState();
        //
        System.out.println(page.title());
        // Close the browser
        browser.close();
    }
}
}
