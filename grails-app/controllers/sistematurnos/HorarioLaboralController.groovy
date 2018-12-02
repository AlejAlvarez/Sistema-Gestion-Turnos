package sistematurnos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HorarioLaboralController {

    HorarioLaboralService horarioLaboralService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond horarioLaboralService.list(params), model:[horarioLaboralCount: horarioLaboralService.count()]
    }

    def show(Long id) {
        respond horarioLaboralService.get(id)
    }

    def create() {
        respond new HorarioLaboral(params)
    }

    def save(HorarioLaboral horarioLaboral) {
        if (horarioLaboral == null) {
            notFound()
            return
        }

        try {
            horarioLaboralService.save(horarioLaboral)
        } catch (ValidationException e) {
            respond horarioLaboral.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'horarioLaboral.label', default: 'HorarioLaboral'), horarioLaboral.id])
                redirect horarioLaboral
            }
            '*' { respond horarioLaboral, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond horarioLaboralService.get(id)
    }

    def update(HorarioLaboral horarioLaboral) {
        if (horarioLaboral == null) {
            notFound()
            return
        }

        try {
            horarioLaboralService.save(horarioLaboral)
        } catch (ValidationException e) {
            respond horarioLaboral.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'horarioLaboral.label', default: 'HorarioLaboral'), horarioLaboral.id])
                redirect horarioLaboral
            }
            '*'{ respond horarioLaboral, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        horarioLaboralService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'horarioLaboral.label', default: 'HorarioLaboral'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'horarioLaboral.label', default: 'HorarioLaboral'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
