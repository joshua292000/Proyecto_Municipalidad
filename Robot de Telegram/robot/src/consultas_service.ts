import axios from 'axios';
import { Telegraf} from 'telegraf';
import { parametros } from './Parametros';
import { Usuario } from './usuario';
import { Cobros, Contribuyentes } from './Cobros';

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
      var Cobros = response.data as Array<Cobros>
      var Mensaje = '';
      for(let entry of Cobros){
        Mensaje += 
        'Tipo de impuesto: ' +entry.tipocobros.nombreTipoCobro+'\n'+
        'Monto: ₡' +entry.cobrosMonto+'\n'+
        'Fecha de creacion: ' +entry.cobrosFechaCreacion+'\n'+
        'Fecha de vencimiento: ' +entry.cobrosFechaVencimiento+'\n';
      }
      var cedula = response.data as Usuario;
      bot.telegram.sendMessage(chat,Mensaje);
    })
    .catch(err => {
      console.log(err, err.response);
    });
}

ListaCobros(token: string, parametro: string, bot: Telegraf,chat:number){
  axios.get('http://localhost:8089/cobros/findByCobrosBetweenCedulaContribuyenteAndFecha/'+parametro, {headers: {    
    Authorization: 'bearer ' + token,
  }}).then(response => {
    var Cobros = response.data as Array<Cobros>
    var Mensaje = '';
    for(let entry of Cobros){
      Mensaje += 
      'Tipo de impuesto: ' +entry.tipocobros.nombreTipoCobro+'\n'+
      'Monto Pagado: ₡' +entry.cobrosMonto+'\n'+
      'Fecha en la que se pago: ' +entry.cobrosFechaPago+'\n';
    }
    var cedula = response.data as Usuario;
    bot.telegram.sendMessage(chat,Mensaje);
  })
  .catch(err => {
    console.log(err, err.response);
  });
}

CobrosPendientes(token: string, parametro: string, bot: Telegraf,chat:number){
  axios.get('http://localhost:8089/cobros/findCobrosByCedulaContribuyentePendientes/'+parametro, {headers: {    
    Authorization: 'bearer ' + token,
  }}).then(response => {
    var suma = 0;
    var Cobros = response.data as Array<Cobros>
    var Mensaje = '';
    for(let entry of Cobros){
      suma=suma+entry.cobrosMonto;
    }
    Mensaje+="Pendiente ₡"+suma+"";
    var cedula = response.data as Usuario;
    bot.telegram.sendMessage(chat,Mensaje);
  })
  .catch(err => {
    console.log(err, err.response);
  });
}

Impuestos(token: string, parametro: string, bot: Telegraf,chat:number){
  axios.get('http://localhost:8089/contribuyentes/findByCedulaContribuyente/'+parametro, {headers: {    
    Authorization: 'bearer ' + token,
  }}).then(response => {
    console.log("Parametros "+ parametro);
    var suma = 0;
    var Contribuyentes = response.data as Array<Contribuyentes>
    var Mensaje = '';
    for(let entry of Contribuyentes){
      
      if(entry.ContribuyenteXLicencia !=null){
        console.log("Entre0");
        Mensaje += 
        'Tipo de impuesto: ' +"Licencia Comercial"+'\n'+
        'Comercio: ' +entry.ContribuyenteXLicencia.licenciacomercial2.nombreComercio+'\n'+
        'Monto Pagado: ₡' +entry.ContribuyenteXLicencia.porcentajeLicencia+'\n'+
        'Fecha en la que se pago: ' +entry.ContribuyenteXLicencia.licenciacomercial2.fechaRegistrocomercio+'\n';
        console.log("Entre 1");
      }
      if(entry.LocalesMercado !=null){
        Mensaje += 
        'Tipo de impuesto: ' +"Local de mercado"+'\n'+
        'Comercio: ' +entry.LocalesMercado.nombreComercio+'\n'+
        'Monto Pagado: ₡' +entry.LocalesMercado.Monto_Alquiler_Local+'\n'+
        'Fecha en la que se pago: ' +entry.LocalesMercado.fechaRegistrolocal+'\n';
        console.log("Entre  2");
      }
      if(entry.Propiedad !=null){
        Mensaje += 
        'Tipo de impuesto: ' +"Propiedades"+'\n'+
        'Area de terreno: ' +entry.Propiedad.propiedadArea+'\n'+
        'Direccion de terreno: ' +entry.Propiedad.propiedadDireccion+'\n'+
        'Monto Pagado: ₡' +entry.Propiedad.propiedadValorTerreno+'\n'+
        'Fecha en la que se pago: ' +entry.Propiedad.propiedad_fecha_Registro+'\n';
        console.log("Entre  3");
      }
    }
    Mensaje+="Pendiente ₡"+suma+"";
    var cedula = response.data as Usuario;
    bot.telegram.sendMessage(chat,Mensaje);
  })
  .catch(err => {
    console.log(err, err.response);
    console.log("Error");
  });
}
}