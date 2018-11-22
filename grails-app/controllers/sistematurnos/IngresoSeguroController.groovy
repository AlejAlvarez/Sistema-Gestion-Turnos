package sistematurnos

import grails.plugin.springsecurity.annotation.Secured

class IngresoSeguroController {

    def index(){
        render 'ACCEDER A /indexAdmin SI ES ADMINISTRADOR, O A /indexPaciente SI ES PACIENTE'
        render 'CUENTA ADMIN: username: admin, password: admin'
        render 'CUENTA PACIENTE: username: paciente, password: paciente'
    }

    @Secured('ROLE_ADMIN')
    def indexAdmin() {
        render 'AUTENTIFICADO COMO ADMINISTRADOR'    
    }

    @Secured('ROLE_PACIENTE')
    def indexPaciente(){
        render 'AUTENTIFICADO COMO PACIENTE'
    }
}
