import { LoginButton } from "telegram-keyboard";

export interface Cobros{
    cobrosMonto: number;
    cobrosFechaCreacion: Date;
    cobrosFechaVencimiento: Date;
    cobrosFechaPago: Date;
    tipocobros: TipoCobros;
    licenciacomercial: Licencias_Comerciales;

}

export interface Contribuyentes{
    cedulaContribuyente: string;
    nombreContribuyente: string;
    ContribuyenteXLicencia: Contribuyentes_Licencias_Comerciales;
    LocalesMercado:LocalesMercado;
    Propiedad:Propiedades;
}

export interface TipoCobros{
    nombreTipoCobro: string;
}

export interface Licencias_Comerciales{
    nombreComercio: string;
    fechaRegistrocomercio: Date;
    ContribuyenteXvLicencia: Contribuyentes_Licencias_Comerciales

}

export interface Contribuyentes_Licencias_Comerciales{
    porcentajeLicencia: number;
    contribuyente: Contribuyentes;
    licenciacomercial2: Licencias_Comerciales;
}

export interface Contribuyentes_LocalesMercado{
    porcentajeLicencia: number;
    contribuyente: Contribuyentes;
    locales_Comercial2: LocalesMercado;
}

export interface Contribuyentes_Propiedades{
    porcentajeLicencia: number;
    contribuyente: Contribuyentes;
    propiedades2: Propiedades;
}
export interface Propiedades{
    propiedad_fecha_Registro: Date;
    propiedadArea:number;
    propiedadDireccion: string;
    propiedadValorTerreno: number;
}

export interface LocalesMercado{
    nombreComercio: string;
    Monto_Alquiler_Local:number;
    fechaRegistrolocal:number;
}
