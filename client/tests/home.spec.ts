import { test, expect } from '@playwright/test';

test('Testing Home page', async ({ page }) => {
    await page.goto('http://localhost:4201/');

    // Expect a title "to contain" a substring.
    await expect(page).toHaveTitle('Home | Playwright & Microcks');
});
