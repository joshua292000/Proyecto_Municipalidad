package org.una.municipalidad.components;

public enum RolesTypes {
    GESTOR("GESTOR"),
    GERENTE("GERENTE"),
    AUDITOR("AUDITOR"),
    ADMINISTRADOR("ADMINISTRADOR");
    private final String codigo;

    RolesTypes(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }


}
