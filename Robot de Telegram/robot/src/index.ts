import { parametros } from './Parametros';
import { Telegraf } from "telegraf";
import { Keyboard } from "telegram-keyboard";
import { user} from "./usuario";
import axios, { Axios } from "axios";
import { consultas_service} from "./consultas_service";

const bot = new Telegraf("2075715068:AAG_ldiisWuyZzSvLPjJrWn-rGPVpyKx0nU")
var token: user;
var tokenInicial=false;
var param: parametros;
var consultasS=new consultas_service;

function logginF(opc:number,parameters:string,bot:Telegraf,chatId:number){
var error = false;
axios.interceptors.response.use(response=>{
  return response;
},
err =>{const{config,response:{status,data}}=err;
const originalRequest = config;
if(status===401||data.message==="Unauthorized"){
  axios.post('http://localhost:8089/autenticacion',{
    cedula:"botTelegram",clave:"bot2021"
  },{headers:{'Content-Type':'application/json'}}
  )
.then(response=>{
  var botToken=response.data as user;
  token.jwt = botToken.jwt;
  consultas(opc,botToken.jwt,parameters,bot,chatId);
  console.log('Se venció el token')
})
.catch(err=>{console.log(err,err.response);});
error=true;
}else{
  console.log('Logueo con éxito');
  consultas(opc,token.jwt,parameters,bot,chatId);
}
}
);
if(!error){
  consultas(opc,token.jwt,parameters,bot,chatId);
}
error=false;
}

function consultas(opc:number,token:string,parameters:string,bot:Telegraf,chatId:number){
  /*switch(opc){
    case 1:
      consultasS.Horario(token,parameters,bot,chatId);
    break;
    case 2:
      consultasS.Formula(token,parameters,bot,chatId);
      break;
  }*/
  if(opc == 1){
    consultasS.Horario(token,parameters,bot,chatId);
  }

}
function inicio(){
  axios.post('http://localhost:8089/autenticacion',{
    cedula:"botTelegram",clave:"bot2021"
  },{headers:{'Content-Type':'application/json'}})
.then(response=>{
  token=response.data as user;
}).catch(err=>{console.log("No copio el token");})
};

bot.start((ctx: any) => ctx.reply('Hola sexy. Escribe "Menu" para comenzar. '))

bot.hears('Menu', async (ctx) => {
  inicio();
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

bot.hears('Horario',async (cxt)=>{
var msg = cxt.message.text;
//var msgArray = msg.split(' ');
logginF(1,msg,bot, cxt.from.id);
})

bot.hears('Formula propiedad',async ctx=>{
  var mensaje=ctx.message.text;
  //var mensaje2=mensaje.split(' ');
  logginF(2,mensaje,bot,ctx.from.id);
  })
//console.log(keyboard)
console.log('start')
bot.launch()