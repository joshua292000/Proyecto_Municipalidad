import axios from 'axios';
import { Telegraf} from 'telegraf';
import { parametros } from './Parametros';

export class consultas_service{

    Horario(token: string, parameters: string, bot: Telegraf,chat:number){
      
        axios.get('http://localhost:8089/parametros/findByLlaveParametro/'+parameters, 
        {headers: {
            Authorization: 'bearer ' + token,
        }}).then(response => {
            var param = response.data as parametros;
            console.log('data tiene: ' + response.data)
            bot.telegram.sendMessage(chat,param.valorParametro);
            //console.log('Entro aqui');
        })
        .catch(err => {
            console.log('Entro al error' + parameters);
            console.log(err, err.response);
        });
    }
    Formula(token: string, parameters: string, bot: Telegraf,chat:number){
        axios.get('http://localhost:8089/parametros/'+parameters, {headers: {    
          Authorization: 'bearer ' + token,
        }}).then(response => {
          var parametro = response.data as parametros;
          bot.telegram.sendMessage(chat,parametro.valorParametro);
        })
        .catch(err => {
          console.log(err, err.response);
        });
  
    }
}