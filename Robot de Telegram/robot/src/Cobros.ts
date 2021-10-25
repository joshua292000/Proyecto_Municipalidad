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
    ContribuyenteXLicencia: Contribuyentes_Licencias_Comerciales
}

export interface TipoCobros{
    nombreTipoCobro: string;
}

export interface Licencias_Comerciales{
    nombreComercio: string;
    ContribuyenteXvLicencia: Contribuyentes_Licencias_Comerciales
}

export interface Contribuyentes_Licencias_Comerciales{
    porcentajeLicencia: number;
    contribuyente: Contribuyentes;
    //licenciacomercial: Licencias_Comerciales;
}

