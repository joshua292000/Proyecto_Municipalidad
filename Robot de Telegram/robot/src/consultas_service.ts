import axios from 'axios';
import {Telegraf} from 'telegraf'
import {usuario} from './usuario';
import { parametros } from './Parametros';

export class consultas_service{
    Horario(token: string, parameters: string, bot: Telegraf){
        axios.get('http://localhost:8089/parametros/' + parameters[1], 
        {headers: {
            Authorization: 'bearer ' + token,
        }}).then(response => {
            var parametro = response.data as parametros;
            bot.telegram.sendMessage(parametro.Horario);
        })
        .catch(err => {
            console.log(err, err.response);
        });
    }
    Formula(token: string, parameters: string, bot: Telegraf){
        axios.get('http://localhost:8089/parametros/'+parameters[1], {headers: {    
          Authorization: 'bearer ' + token,
        }}).then(response => {
          var param = response.data as parametro;
          bot.telegram.sendMessage(param.Formula);
        })
        .catch(err => {
          console.log(err, err.response);
        });
  
    }
}