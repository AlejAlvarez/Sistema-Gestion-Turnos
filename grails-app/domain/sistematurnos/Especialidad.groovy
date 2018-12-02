package sistematurnos

class Especialidad {

    String nombre
    
    static hasMany = [medicos:InformacionMedico]
    
    static constraints = {
    }
}
