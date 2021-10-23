export interface UsuariosDTO{
    id: number;
    nombreUsuario: string;
    claveEncriptado: string;
    cedula:string;
    estado: boolean;
    roles: RolesDTO;
}

export interface RolesDTO{
    id: number;
    nombreRol: string;
    descripcionRol: string;
    estado: boolean;
}

export interface user{
    jwt: string;
    usuario: UsuariosDTO;
}