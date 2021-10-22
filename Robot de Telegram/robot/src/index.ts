import { text } from "stream/consumers";
import { Telegraf } from "telegraf";
import { Keyboard } from "telegram-keyboard";



const bot = new Telegraf("2075715068:AAG_ldiisWuyZzSvLPjJrWn-rGPVpyKx0nU")
bot.telegram.getMe().then((botInfo: any) => {
  bot.options.username = botInfo.username;
});
bot.start((ctx: any) => ctx.reply('Hola sexy. Escribe "Menu" para comenzar. '))

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
//console.log(keyboard)
console.log('start')
bot.launch()