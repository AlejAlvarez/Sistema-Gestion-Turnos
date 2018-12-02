package sistematurnos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SobreturnoController {

    SobreturnoService sobreturnoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sobreturnoService.list(params), model:[sobreturnoCount: sobreturnoService.count()]
    }

    def show(Long id) {
        respond sobreturnoService.get(id)
    }

    def create() {
        respond new Sobreturno(params)
    }

    def save(Sobreturno sobreturno) {
        if (sobreturno == null) {
            notFound()
            return
        }

        try {
            sobreturnoService.save(sobreturno)
        } catch (ValidationException e) {
            respond sobreturno.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sobreturno.label', default: 'Sobreturno'), sobreturno.id])
                redirect sobreturno
            }
            '*' { respond sobreturno, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sobreturnoService.get(id)
    }

    def update(Sobreturno sobreturno) {
        if (sobreturno == null) {
            notFound()
            return
        }

        try {
            sobreturnoService.save(sobreturno)
        } catch (ValidationException e) {
            respond sobreturno.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sobreturno.label', default: 'Sobreturno'), sobreturno.id])
                redirect sobreturno
            }
            '*'{ respond sobreturno, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sobreturnoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sobreturno.label', default: 'Sobreturno'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sobreturno.label', default: 'Sobreturno'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
