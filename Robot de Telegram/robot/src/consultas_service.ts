import axios from 'axios';
import { Telegraf} from 'telegraf';
import { parametros } from './Parametros';
import { Usuario } from './usuario';

export class consultas_service{

    Horario(token: string, parametro: string, bot: Telegraf,chat:number){
      
        axios.get('http://localhost:8089/parametros/findByLlaveParametro/'+parametro, 
        {headers: {
            Authorization: 'bearer ' + token,
        }}).then(response => {
            var param = response.data as parametros;
            console.log('data tiene: ' + response.data)
            bot.telegram.sendMessage(chat,param.valorParametro);
            //console.log('Entro aqui');
        })
        .catch(err => {
            console.log('Entro al error' + parametro);
            console.log(err, err.response);
        });
    }
    Formula(token: string, parametro: string, bot: Telegraf,chat:number){
        axios.get('http://localhost:8089/parametros/findByLlaveParametro/'+parametro, {headers: {    
          Authorization: 'bearer ' + token,
        }}).then(response => {
          var parametro = response.data as parametros;
          bot.telegram.sendMessage(chat,parametro.valorParametro);
        })
        .catch(err => {
          console.log(err, err.response);
        });
  
    }
    Telefono(token: string, parametro: string, bot: Telegraf,chat:number){
      axios.get('http://localhost:8089/parametros/findByLlaveParametro/'+parametro, {headers: {    
        Authorization: 'bearer ' + token,
      }}).then(response => {
        var parametro = response.data as parametros;
        bot.telegram.sendMessage(chat,parametro.valorParametro);
      })
      .catch(err => {
        console.log(err, err.response);
      });
  }

  Cobrospagados(token: string, parametro: string, bot: Telegraf,chat:number){
    axios.get('http://localhost:8089/cobros/findCobrosByCedulaContribuyente/'+parametro, {headers: {    
      Authorization: 'bearer ' + token,
    }}).then(response => {
      var cedula = response.data as Usuario;
      bot.telegram.sendMessage(chat,cedula.jwt);
    })
    .catch(err => {
      console.log(err, err.response);
    });
}
}