package sistematurnos

import java.sql.Time

class Turno {

    Date fechaRegistro
    Time fechaAtencion
    String estado
    
    InformacionPaciente paciente
    
    static hasMany = [medicos:InformacionMedico]
    
    static constraints = {
    }
}
