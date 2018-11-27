package sistematurnos

class ObraSocial {

    String nombre
    
    static hasMany = [pacientes:InformacionPaciente]
    
    static constraints = {
    }
}
