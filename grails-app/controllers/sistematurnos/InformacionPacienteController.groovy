package sistematurnos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InformacionPacienteController {

    InformacionPacienteService informacionPacienteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond informacionPacienteService.list(params), model:[informacionPacienteCount: informacionPacienteService.count()]
    }

    def show(Long id) {
        respond informacionPacienteService.get(id)
    }

    def create() {
        // en este controller se tiene que crear también con los fields de informacionUsuario
        respond new InformacionPaciente(params)
    }

    def save(InformacionPaciente informacionPaciente) {
        if (informacionPaciente == null) {
            notFound()
            return
        }

        try {
            informacionPacienteService.save(informacionPaciente)
        } catch (ValidationException e) {
            respond informacionPaciente.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'informacionPaciente.label', default: 'InformacionPaciente'), informacionPaciente.id])
                redirect informacionPaciente
            }
            '*' { respond informacionPaciente, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond informacionPacienteService.get(id)
    }

    def update(InformacionPaciente informacionPaciente) {
        if (informacionPaciente == null) {
            notFound()
            return
        }

        try {
            informacionPacienteService.save(informacionPaciente)
        } catch (ValidationException e) {
            respond informacionPaciente.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'informacionPaciente.label', default: 'InformacionPaciente'), informacionPaciente.id])
                redirect informacionPaciente
            }
            '*'{ respond informacionPaciente, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        informacionPacienteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'informacionPaciente.label', default: 'InformacionPaciente'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'informacionPaciente.label', default: 'InformacionPaciente'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
