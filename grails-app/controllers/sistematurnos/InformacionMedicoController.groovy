package sistematurnos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InformacionMedicoController {

    InformacionMedicoService informacionMedicoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond informacionMedicoService.list(params), model:[informacionMedicoCount: informacionMedicoService.count()]
    }

    def show(Long id) {
        respond informacionMedicoService.get(id)
    }

    def create() {
        respond new InformacionMedico(params)
    }

    def save(InformacionMedico informacionMedico) {
        if (informacionMedico == null) {
            notFound()
            return
        }

        try {
            informacionMedicoService.save(informacionMedico)
        } catch (ValidationException e) {
            respond informacionMedico.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'informacionMedico.label', default: 'InformacionMedico'), informacionMedico.id])
                redirect informacionMedico
            }
            '*' { respond informacionMedico, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond informacionMedicoService.get(id)
    }

    def update(InformacionMedico informacionMedico) {
        if (informacionMedico == null) {
            notFound()
            return
        }

        try {
            informacionMedicoService.save(informacionMedico)
        } catch (ValidationException e) {
            respond informacionMedico.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'informacionMedico.label', default: 'InformacionMedico'), informacionMedico.id])
                redirect informacionMedico
            }
            '*'{ respond informacionMedico, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        informacionMedicoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'informacionMedico.label', default: 'InformacionMedico'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'informacionMedico.label', default: 'InformacionMedico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
