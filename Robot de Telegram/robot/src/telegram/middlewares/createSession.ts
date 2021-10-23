import { Context, Middleware } from "telegraf";
import { ComandosBot, MuniContext } from "../../types";

const createSession: Middleware<MuniContext>=async(ctx,next)=>{
    Object.assign(ctx,{...ctx,session:{}});
    return next();
}

export default createSession;