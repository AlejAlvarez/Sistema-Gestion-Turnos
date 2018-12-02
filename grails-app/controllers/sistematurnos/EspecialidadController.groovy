package sistematurnos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EspecialidadController {

    EspecialidadService especialidadService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond especialidadService.list(params), model:[especialidadCount: especialidadService.count()]
    }

    def show(Long id) {
        respond especialidadService.get(id)
    }

    def create() {
        respond new Especialidad(params)
    }

    def save(Especialidad especialidad) {
        if (especialidad == null) {
            notFound()
            return
        }

        try {
            especialidadService.save(especialidad)
        } catch (ValidationException e) {
            respond especialidad.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'especialidad.label', default: 'Especialidad'), especialidad.id])
                redirect especialidad
            }
            '*' { respond especialidad, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond especialidadService.get(id)
    }

    def update(Especialidad especialidad) {
        if (especialidad == null) {
            notFound()
            return
        }

        try {
            especialidadService.save(especialidad)
        } catch (ValidationException e) {
            respond especialidad.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'especialidad.label', default: 'Especialidad'), especialidad.id])
                redirect especialidad
            }
            '*'{ respond especialidad, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        especialidadService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'especialidad.label', default: 'Especialidad'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'especialidad.label', default: 'Especialidad'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
