package sistematurnos

import grails.plugin.springsecurity.annotation.Secured

class IngresoSeguroController {

    //CUENTA ADMIN: username: admin, password: admin
    //CUENTA PACIENTE: username: paciente, password: paciente
    @Secured(['ROLE_ADMIN', 'ROLE_RECEPCIONISTA', 'ROLE_MEDICO', 'ROLE_PACIENTE'])
    def index(){
        if (isLoggedIn()){
            def rol = getAuthenticatedUser().rol
            switch(rol) {
                case "admin":
                    render 'AUTENTIFICADO COMO ADMINISTRADOR'
                    break
                case "paciente":
                    render 'AUTENTIFICADO COMO PACIENTE'
                    break
                case "medico":
                    render 'AUTENTIFICADO COMO MEDICO'
                    break
                case "recepcionista":
                    render 'AUTENTIFICADO COMO RECEPCIONISTA'
                    break
            }
        }
        else{
            render 'USTED NO POSEE NINGUN PERMISO'
        }
        
    }

}
