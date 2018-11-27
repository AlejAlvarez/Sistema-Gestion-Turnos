package sistematurnos

class Turno {
    
    Date fechaReservada
    Date fechaRegistro
    String estado
    
    InformacionPaciente paciente
    
    static hasMany = [medicos:InformacionMedico]
    
    static constraints = {
    }
}
