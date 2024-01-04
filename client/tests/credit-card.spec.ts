import { test, expect } from '@playwright/test';

test('Testing menu', async ({ page }) => {
    await page.goto('/');
    await page.getByLabel('Click to open menu').click();
    await page.getByRole('button', { name: 'Credit Card' }).click();
    await page.getByLabel('Credit Card').click();

    await expect(page).toHaveTitle('Credit Card | Playwright & Microcks');
});

/*
test('Testing input', async ({ page }) => {
    await page.goto('http://localhost:4200/crdt-crd');
    await expect(page).toHaveTitle('Credit Card | Playwright & Microcks');

    await page.getByLabel('Credit Card').fill('1234123412341234');
    await expect(page.locator('.split-content > .container')).toHaveText('1234123412341234');
});
*/
