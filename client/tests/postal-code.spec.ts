import { test, expect } from '@playwright/test';

test('Testing menu', async ({ page }) => {
    await page.goto('http://localhost:4200/');

    await page.getByLabel('Click to open menu').click();
    await page.getByRole('button', { name: 'Postal Code' }).click();
    await page.getByLabel('Postal Code').click();

    await expect(page).toHaveTitle('Postal Code | Playwright & Microcks');
});


test('Testing Greeting', async ({ page }) => {
    await page.goto('http://localhost:4200/pstl-cd');
    await expect(page).toHaveTitle('Postal Code | Playwright & Microcks');

    await page.getByRole('button', { name: 'TEST GREETING' }).click();
    await expect(page.locator('.split-content > .container')).toHaveText('Hello, you have reached the Postal Code Validation service');
});

test('Testing service root', async ({ page }) => {
    await page.goto('http://localhost:4200/pstl-cd');
    await expect(page).toHaveTitle('Postal Code | Playwright & Microcks');

    await page.getByRole('button', { name: 'TEST SERVICE ROOT' }).click();
    await expect(page.locator('.split-content > .container')).toHaveText('Please provide a postal code and a provice as separate URI params (Postal Code / Province Code)');
});


test('Testing invalid postal code', async ({ page }) => {
    await page.goto('http://localhost:4200/pstl-cd');
    await expect(page).toHaveTitle('Postal Code | Playwright & Microcks');

    await page.getByLabel('Postal Code').fill('aaaaaa');
    await page.getByLabel('Province / Territories').selectOption('ON');

    await page.getByRole('button', { name: 'TEST VALIDATION' }).click();
    await expect(page.locator('.split-content > .container')).toHaveText('Validation attempt for postal code "aaaaaa" in province "ON". [Postal Code Validation] Failed number validation.');
});


test('Testing Ontario postal code', async ({ page }) => {
    await page.goto('http://localhost:4200/pstl-cd');
    await expect(page).toHaveTitle('Postal Code | Playwright & Microcks');

    await page.getByLabel('Postal Code').fill('K1A 1A1');
    await page.getByLabel('Province / Territories').selectOption('ON');

    await page.getByRole('button', { name: 'TEST VALIDATION' }).click();
    await expect(page.locator('.split-content > .container')).toHaveText('Validation attempt for postal code "K1A 1A1" in province "ON". [Postal Code Validation] Valid.');
});
