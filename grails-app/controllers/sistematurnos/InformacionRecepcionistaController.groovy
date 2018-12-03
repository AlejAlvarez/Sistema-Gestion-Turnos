package sistematurnos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InformacionRecepcionistaController {

    InformacionRecepcionistaService informacionRecepcionistaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond informacionRecepcionistaService.list(params), model:[informacionRecepcionistaCount: informacionRecepcionistaService.count()]
    }

    def show(Long id) {
        respond informacionRecepcionistaService.get(id)
    }

    def create() {
        respond new InformacionRecepcionista(params)
    }

    def save(InformacionRecepcionista informacionRecepcionista) {
        if (informacionRecepcionista == null) {
            notFound()
            return
        }

        try {
            informacionRecepcionistaService.save(informacionRecepcionista)
        } catch (ValidationException e) {
            respond informacionRecepcionista.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'informacionRecepcionista.label', default: 'InformacionRecepcionista'), informacionRecepcionista.id])
                redirect informacionRecepcionista
            }
            '*' { respond informacionRecepcionista, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond informacionRecepcionistaService.get(id)
    }

    def update(InformacionRecepcionista informacionRecepcionista) {
        if (informacionRecepcionista == null) {
            notFound()
            return
        }

        try {
            informacionRecepcionistaService.save(informacionRecepcionista)
        } catch (ValidationException e) {
            respond informacionRecepcionista.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'informacionRecepcionista.label', default: 'InformacionRecepcionista'), informacionRecepcionista.id])
                redirect informacionRecepcionista
            }
            '*'{ respond informacionRecepcionista, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        informacionRecepcionistaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'informacionRecepcionista.label', default: 'InformacionRecepcionista'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'informacionRecepcionista.label', default: 'InformacionRecepcionista'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
