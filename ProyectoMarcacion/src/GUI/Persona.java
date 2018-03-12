/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author ivana
 */
public class Persona {
    
    
    String Rut;
    String Apellido;
    String Nombre;
    String Empresa;
    String Cargo;

    public Persona(String Rut, String Apellido, String Nombre, String Empresa, String Cargo) {
        this.Rut = Rut;
        this.Apellido = Apellido;
        this.Nombre = Nombre;
        this.Empresa = Empresa;
        this.Cargo = Cargo;
    }

    public String getRut() {
        return Rut;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getNombre() {
        return Nombre;
    }


    public String getEmpresa() {
        return Empresa;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }


    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    
    
}
