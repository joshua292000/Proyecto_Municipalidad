import axios from 'axios';
import { Telegraf} from 'telegraf';
import { parametros } from './Parametros';



export class consultas_service{
    Horario(token: string, parameters: string, bot: Telegraf,chat:number){
        axios.get('http://localhost:8089/parametros/' + parameters[1], 
        {headers: {
            Authorization: 'bearer ' + token,
        }}).then(response => {
            var parametro = response.data as parametros;
            bot.telegram.sendMessage(chat,parametro.valor_parametro);
        })
        .catch(err => {
            console.log(err, err.response);
        });
    }
    Formula(token: string, parameters: string, bot: Telegraf,chat:number){
        axios.get('http://localhost:8089/parametros/'+parameters[1], {headers: {    
          Authorization: 'bearer ' + token,
        }}).then(response => {
          var param = response.data as parametros;
          bot.telegram.sendMessage(chat,param.valor_parametro);
        })
        .catch(err => {
          console.log(err, err.response);
        });
  
    }
}