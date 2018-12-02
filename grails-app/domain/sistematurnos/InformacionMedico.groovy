package sistematurnos

class InformacionMedico extends InformacionUsuario{
    
    String cuil
    Especialidad especialidad
    
    static hasMany = [turnos:Turno, horarios:HorarioLaboral]
    static constraints = {
    }
}
