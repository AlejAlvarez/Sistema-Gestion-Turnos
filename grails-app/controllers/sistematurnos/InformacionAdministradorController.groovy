package sistematurnos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InformacionAdministradorController {

    InformacionAdministradorService informacionAdministradorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond informacionAdministradorService.list(params), model:[informacionAdministradorCount: informacionAdministradorService.count()]
    }

    def show(Long id) {
        respond informacionAdministradorService.get(id)
    }

    def create() {
        respond new InformacionAdministrador(params)
    }

    def save(InformacionAdministrador informacionAdministrador) {
        if (informacionAdministrador == null) {
            notFound()
            return
        }

        try {
            informacionAdministradorService.save(informacionAdministrador)
        } catch (ValidationException e) {
            respond informacionAdministrador.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'informacionAdministrador.label', default: 'InformacionAdministrador'), informacionAdministrador.id])
                redirect informacionAdministrador
            }
            '*' { respond informacionAdministrador, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond informacionAdministradorService.get(id)
    }

    def update(InformacionAdministrador informacionAdministrador) {
        if (informacionAdministrador == null) {
            notFound()
            return
        }

        try {
            informacionAdministradorService.save(informacionAdministrador)
        } catch (ValidationException e) {
            respond informacionAdministrador.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'informacionAdministrador.label', default: 'InformacionAdministrador'), informacionAdministrador.id])
                redirect informacionAdministrador
            }
            '*'{ respond informacionAdministrador, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        informacionAdministradorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'informacionAdministrador.label', default: 'InformacionAdministrador'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'informacionAdministrador.label', default: 'InformacionAdministrador'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
