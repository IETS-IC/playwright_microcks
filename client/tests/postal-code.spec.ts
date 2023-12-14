import { test, expect } from '@playwright/test';

test('Testing menu', async ({ page }) => {
    await page.goto('http://localhost:4200/');

    await page.getByLabel('Click to open menu').click();
    await page.getByRole('button', { name: 'Postal Code' }).click();
    await page.getByLabel('Postal Code').click();

    await expect(page).toHaveTitle('Postal Code | Playwright & Microcks');
});

test('Testing input', async ({ page }) => {
    await page.goto('http://localhost:4200/pstl-cd');
    await expect(page).toHaveTitle('Postal Code | Playwright & Microcks');

    await page.getByLabel('Postal Code').click();
    await page.getByLabel('Postal Code').fill('K1A 1A1');

    await page.getByLabel('Province / Territories').selectOption('ON');

    await expect(page.locator('.split-content > .container')).toHaveText('K1A 1A1ON');
});
