package sistematurnos

class BootStrap {

    def init = { servletContext ->
        
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()

        def pacienteRole = new Role(authority: 'ROLE_PACIENTE').save()

        def admin = new User(username: 'admin', password: 'admin').save()

        def paciente = new User(username: 'paciente', password: 'paciente').save()

        UserRole.create admin, adminRole
        UserRole.create paciente, pacienteRole

        UserRole.withSession{
            it.flush()
            it.clear()
        }

        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 2
        
    }
    def destroy = {
    }
}
