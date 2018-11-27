package sistematurnos

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()

        //def pacienteRole = new Role(authority: 'ROLE_PACIENTE').save()
        
        def informacion = new InformacionUsuario(documento: '11122233', nombre: "Alejandro", apellido: "Alvarez", telefono: "12345678",
            nacimiento: "26/04/1998", domicilio: "Calle Falsa 1234", fechaRegistro: "26/11/2018", email: "alejandro@user.com").save()
        def admin = new User(username: 'admin', password: 'admin', rol: 'admin', info: informacion).save()
        /*informacion.usuario = admin
        informacion.save()*/

        /*def paciente = new User(username: 'paciente', password: 'paciente')
        paciente.rol = "paciente"
        paciente.save()*/

        UserRole.create admin, adminRole
        
        //UserRole.create paciente, pacienteRole

        UserRole.withSession{
            it.flush()
            it.clear()
        }

        assert User.count() == 1
        assert Role.count() == 1
        assert UserRole.count() == 1
    }
    def destroy = {
    }
}
