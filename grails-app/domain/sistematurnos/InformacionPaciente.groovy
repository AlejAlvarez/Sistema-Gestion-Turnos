package sistematurnos

class InformacionPaciente extends InformacionUsuario {

    String genero
    
    ObraSocial obraSocial
    
    static hasMany = [turnos:Turno]
    
    static constraints = {
    }
}
