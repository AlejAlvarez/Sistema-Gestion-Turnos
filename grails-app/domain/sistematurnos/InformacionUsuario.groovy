package sistematurnos

class InformacionUsuario {
    
    String documento
    String nombre
    String apellido
    String telefono
    String nacimiento
    String domicilio
    String fechaRegistro
    String email
    
    static belongsTo = User

    static constraints = {
        documento()
        nombre()
        apellido()
        telefono()
        email()
        domicilio()
        fechaRegistro()
    }
}
