import { parametros } from './Parametros';
import { Telegraf } from "telegraf";
import { Keyboard } from "telegram-keyboard";
import { usuario } from "./usuario";
import axios, { Axios } from "axios";
import { consultas_service} from "./consultas_service";

const bot = new Telegraf("2075715068:AAG_ldiisWuyZzSvLPjJrWn-rGPVpyKx0nU")
var loggin: usuario;
var tokenInicial=false;
var consultasS=new consultas_service;

function logginF(opc:number,parameters:string[],bot:Telegraf,chatId:number){
var error = false;
axios.interceptors.response.use(response=>{
  return response;
},
err =>{const{config,response:{status,data}}=err;
const originalRequest = config;
if(status===401||data.message==="Unauthorized"){
  axios.post('http://localhost:8089/Autenticaciones',{
    cedula:"botTelegram",contrasenia:"bot2021"
  },{headers:{'Content-Type':'application/json'}})
.then(response=>{
  var botToken=response.data as usuario;
  loggin.tokencito=botToken.tokencito;
  consultas(opc,botToken.tokencito,parameters,bot,chatId);
  console.log('Se venció el token')
})
.catch(err=>{console.log(err,err.response);});
error=true;
}else{
  console.log('Logueo con éxito');
  consultas(opc,loggin.tokencito,parameters,bot,chatId);
}
}
);
if(!error){
  consultas(opc,loggin.tokencito,parameters,bot,chatId);
}
error=false;
}

function consultas(opc:number,token:string,parameters:string[],bot:Telegraf,chatId:number){
  switch(opc){
    case 1:
      consultasS.Horario(token,parameters,bot,chatId);
    break;
    case 2:
      consultasS.Formula(token,parameters,bot,chatId);
  }

}
function inicio(){
  axios.post('http://localhost:8089/Autenticaciones',{
    cedula:"botTelegram",contrasenia:"bot2021"
  },{headers:{'Content-Type':'application/json'}})
.then(response=>{
  loggin=response.data as usuario;
}).catch(err=>{console.log(err,err.response)})
};

bot.start((ctx: any) => ctx.reply('Hola sexy. Escribe "Menu" para comenzar. '))
inicio();
bot.hears('Menu', async (ctx) => {
  const keyboard = Keyboard.make([
    ['Consulta simple'],
    ['Consulta personal'],
    
  ])
 await ctx.reply('Seleccione una opcion', keyboard.reply())
 ctx.reply('Consulta simple: En estas se pueden realizar consultas que no ocupen de su cedula')
 ctx.reply('Consulta personal: En estas puedes consultar acerca de tus pendientes')

 //await ctx.reply('', keyboard.inline())
})

bot.hears('Consulta simple', async ctx => {
  //await ctx.reply('horario')
  const keyboard = Keyboard.make([
    ['Horario'],
    ['Formula propiedad'],
    
  ])
 await ctx.reply('Seleccione una opcion', keyboard.reply())
 ctx.reply('Horario: Consulta el horario de la muni')
 ctx.reply('Formula propiedad: Consulta la formula del impuesto de la propiedad')
});

bot.hears('Horario',async ctx=>{
var mensaje=ctx.message.text;
var mensaje2=mensaje.split(' ');
logginF(1,mensaje2,bot,ctx.from.id);
})

bot.hears('Formula propiedad',async ctx=>{
  var mensaje=ctx.message.text;
  var mensaje2=mensaje.split(' ');
  logginF(1,mensaje2,bot,ctx.from.id);
  })
//console.log(keyboard)
console.log('start')
bot.launch()