import { Context } from "telegraf";

export enum ComandosBot{
   Menu = 'Menu',
}

interface  ISessionData {
    page?: number;
    itemCount?: number;
}

export interface MuniContext extends Context{
session: ISessionData;
match: RegExpExecArray|undefined;
}