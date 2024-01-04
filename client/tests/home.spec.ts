import { test, expect } from '@playwright/test';

test.only('Testing Home page', async ({ page }) => {
    await page.goto('/');

    // Expect a title "to contain" a substring.
    await expect(page).toHaveTitle('Home | Playwright & Microcks');
});
