import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class DisplayService {

    private _result: string;

    constructor() {
        this._result = '';
    }

    public get result(): string {
        return this._result;
    }

    public set result(value: string) {
        this._result = value;
    }
}
