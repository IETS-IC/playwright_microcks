import { test, expect } from '@playwright/test';

test('Testing menu', async ({ page }) => {
    await page.goto('http://localhost:4200/');
    await page.getByLabel('Click to open menu').click();
    await page.getByRole('button', { name: 'Credit Card' }).click();
    await page.getByLabel('Credit Card').click();

    await expect(page).toHaveTitle('Credit Card | Playwright & Microcks');
});

test('Testing Greeting', async ({ page }) => {
    await page.goto('http://localhost:4200/crdt-crd');
    await expect(page).toHaveTitle('Credit Card | Playwright & Microcks');

    await page.getByRole('button', { name: 'TEST GREETING' }).click();
    await expect(page.locator('.split-content > .container')).toHaveText('Hello, you have reached the Credit Card Validation service');
});

test('Testing service root', async ({ page }) => {
    await page.goto('http://localhost:4200/crdt-crd');
    await expect(page).toHaveTitle('Credit Card | Playwright & Microcks');

    await page.getByRole('button', { name: 'TEST SERVICE ROOT' }).click();
    await expect(page.locator('.split-content > .container')).toHaveText('Please provide a credit card number as a URI param');
});

test('Testing invalid credit card', async ({ page }) => {
    await page.goto('http://localhost:4200/crdt-crd');
    await expect(page).toHaveTitle('Credit Card | Playwright & Microcks');

    await page.getByPlaceholder('Ex.').fill('1234123412341234');
    await page.getByRole('button', { name: 'TEST VALIDATION' }).click();
    await expect(page.locator('.split-content > .container')).toHaveText('Validation attempt for credit card number "1234123412341234". [Credit Card Validation] Failed number validation.');
});

test('Testing amex', async ({ page }) => {
    await page.goto('http://localhost:4200/crdt-crd');
    await expect(page).toHaveTitle('Credit Card | Playwright & Microcks');

    await page.getByPlaceholder('Ex.').fill('374245455400126');
    await page.getByRole('button', { name: 'TEST VALIDATION' }).click();
    await expect(page.locator('.split-content > .container')).toHaveText('Validation attempt for credit card number "374245455400126". [Credit Card Validation] Valid.');
});

test('Testing mastercard', async ({ page }) => {
    await page.goto('http://localhost:4200/crdt-crd');
    await expect(page).toHaveTitle('Credit Card | Playwright & Microcks');

    await page.getByPlaceholder('Ex.').fill('5425233430109903');
    await page.getByRole('button', { name: 'TEST VALIDATION' }).click();
    await expect(page.locator('.split-content > .container')).toHaveText('Validation attempt for credit card number "5425233430109903". [Credit Card Validation] Valid.');
});

test('Testing visa debit', async ({ page }) => {
    await page.goto('http://localhost:4200/crdt-crd');
    await expect(page).toHaveTitle('Credit Card | Playwright & Microcks');

    await page.getByPlaceholder('Ex.').fill('4701322211111234');
    await page.getByRole('button', { name: 'TEST VALIDATION' }).click();
    await expect(page.locator('.split-content > .container')).toHaveText('Validation attempt for credit card number "4701322211111234". [Credit Card Validation] Valid.');
});