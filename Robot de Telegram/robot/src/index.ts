import { parametros } from './DTO/usuarioDTO';
import { Telegraf } from "telegraf";
import { Keyboard } from "telegram-keyboard";
import { Usuario} from "./DTO/usuarioDTO";
import axios, { Axios } from "axios";
import { consultas_service} from "./Service/consultasService";

const bot = new Telegraf("2139269968:AAEbv7Qs7FP-fv4v6sRMyvtmrkSx2IJ-BIo")
var token: Usuario;
var consultasS=new consultas_service;

function logginF(consultaL:number,parametroL:string,idL:number, estado:string){
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
  var botToken=response.data as Usuario;
  token.jwt = botToken.jwt;
  consultas(consultaL,botToken.jwt,parametroL,bot,idL,estado);
  console.log('Se venció el token')
})
.catch(err=>{console.log(err,err.response);});
error=true;
}else{
  console.log('Logueo con éxito');
  consultas(consultaL,token.jwt,parametroL,bot,idL,estado);
}
}
);
if(!error){
  consultas(consultaL,token.jwt,parametroL,bot,idL,estado);
}
error=false;
}

function consultas(consultaC:number,tokenC:string,parametroC:string,botC:Telegraf,idC:number,estado:string){
  switch(consultaC){
    case 1:
      consultasS.Horario(tokenC,parametroC,bot,idC,estado);
    break;
    case 2:
      consultasS.Formula(tokenC,parametroC,bot,idC,estado);
    break;
    case 3:
      consultasS.Formula(tokenC,parametroC,bot,idC,estado);
    break;
    case 4:
      consultasS.Formula(tokenC,parametroC,bot,idC,estado);
    break;
    case 5:
      consultasS.Telefono(tokenC,parametroC,bot,idC,estado);
    break;
    case 6:
      consultasS.Cobrospagados(tokenC,parametroC,bot,idC,estado);
    break;
    case 7:
      consultasS.ListaCobros(tokenC,parametroC,bot,idC,estado);
    break;
    case 8:
      consultasS.CobrosPendientes(tokenC,parametroC,bot,idC,estado);
    break;
    case 9:
      consultasS.Impuestos(tokenC,parametroC,bot,idC,estado);
    break;
  }
}
function inicio(){
  axios.post('http://localhost:8089/autenticacion',{
    cedula:"botTelegram",clave:"bot2021"
  },{headers:{'Content-Type':'application/json'}})
.then(response=>{
  token=response.data as Usuario;
}).catch(err=>{console.log("No copio el token");})
};

bot.start((ctx: any) => ctx.reply('👋Hola.😊Escribe "Menu" para comenzar. '))

bot.hears('Menu', async (ctx) => {
  inicio();
  const keyboard = Keyboard.make([
    ['😉Consulta simple'],
    ['😃Consulta personal'],
    
  ])
 await ctx.reply('🔔Seleccione una opcion', keyboard.reply())
 ctx.reply('😉Consulta simple: En estas se pueden realizar consultas que no ocupen de su cedula')
 ctx.reply('😃Consulta personal: En estas puedes consultar acerca de tus pendientes')

})

bot.hears('😉Consulta simple', async ctx => {
  const keyboard = Keyboard.make([
    ['Horario'],
    ['Formula impuesto de licencia comercial'],
    ['Formula bienes inmuebles'],
    ['Formula locales de mercado'],
    ['Telefono']
  ])
 await ctx.reply('🔔Seleccione una opcion', keyboard.reply())
 ctx.reply('Horario: ⏰Consulta el horario de la muni')
 ctx.reply('Fórmula impuesto de licencia comercial: 😎Consulta la fórmula del impuesto de licencia comercial')
 ctx.reply('Fórmula bienes inmuebles: 😎Consulta la fórmula para calcular el monto de los bienes inmuebles')
 ctx.reply('Fórmula locales de mercado:😎 Consulta la fórmula para calcular el monto de los locales de mercado')
 ctx.reply('Teléfono: ☎Consulta el teléfono de la municipalidad')
});

bot.hears('Horario',async (cxt)=>{
var msg = cxt.message.text;
logginF(1,msg, cxt.from.id,"");
})

bot.hears('Formula impuesto de licencia comercial',async ctx=>{
  var mensaje=ctx.message.text;
  logginF(2,mensaje,ctx.from.id,"");
  })

bot.hears('Formula bienes inmuebles',async ctx=>{
  var messag=ctx.message.text;
  logginF(3,messag,ctx.from.id,"");
  })

bot.hears('Formula locales de mercado',async ctx=>{
  var m=ctx.message.text;
  logginF(4,m,ctx.from.id,"");
  })

bot.hears('Telefono',async ctx=>{
    var m=ctx.message.text;
    logginF(5,m,ctx.from.id,"");
    })

    bot.hears('😃Consulta personal', async ctx => {
      const keyboard = Keyboard.make([
        ['Lista de cobros pagados'],
        ['Pagos realizados'],
        ['Pendientes'],
        ['Impuestos contribuyentes'],
      ])
     await ctx.reply('Seleccione una opción', keyboard.reply())
     ctx.reply('Lista de cobros pagados:🔍Obtiene una lista de los cobros pagados')
     ctx.reply('Pagos realizados: 🔍Obtiene una lista de los pagos realizados últimamente')
     ctx.reply('Pendientes: 🔍Obtiene el total de pendientes')
     ctx.reply('Impuestos contribuyentes:🔍 Consulta sobre los impuestos que posee un contribuyente')
    });

    bot.hears('Lista de cobros pagados',async (cxt)=>{
      cxt.reply('⭐Digite su número de cédula⭐')
      bot.on('text', async(ctx)=>{
        var m=ctx.message.text;
        logginF(6,m,ctx.from.id,"Pagado");
      })
      })

    bot.hears('Pagos realizados',async (cxt)=>{
      cxt.reply('⭐Digite su número de cedula y dos fechas por ejemplo /123456789/2021-09-25/2021-10-25⭐')
      bot.on('text', async(ctx)=>{
        var m=ctx.message.text;
        logginF(7,m,ctx.from.id,"Pagado");
      })
    })

    bot.hears('Pendientes',async (cxt)=>{
      cxt.reply('⭐Digite su número de cédula⭐')
      bot.on('text', async(ctx)=>{
        var m=ctx.message.text;
        logginF(8,m,ctx.from.id,"Pendiente");
      })
    })

    bot.hears('Impuestos contribuyentes',async (cxt)=>{
      cxt.reply('⭐Digite su número de cédula⭐')
      bot.on('text', async(ctx)=>{
        var m=ctx.message.text;
        var estado="";
        logginF(9,m,ctx.from.id,estado);
      })
    })

console.log('start')
bot.launch()