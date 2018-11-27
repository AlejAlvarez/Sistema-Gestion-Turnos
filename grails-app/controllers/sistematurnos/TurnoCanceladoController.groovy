package sistematurnos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TurnoCanceladoController {

    TurnoCanceladoService turnoCanceladoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond turnoCanceladoService.list(params), model:[turnoCanceladoCount: turnoCanceladoService.count()]
    }

    def show(Long id) {
        respond turnoCanceladoService.get(id)
    }

    def create() {
        respond new TurnoCancelado(params)
    }

    def save(TurnoCancelado turnoCancelado) {
        if (turnoCancelado == null) {
            notFound()
            return
        }

        try {
            turnoCanceladoService.save(turnoCancelado)
        } catch (ValidationException e) {
            respond turnoCancelado.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'turnoCancelado.label', default: 'TurnoCancelado'), turnoCancelado.id])
                redirect turnoCancelado
            }
            '*' { respond turnoCancelado, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond turnoCanceladoService.get(id)
    }

    def update(TurnoCancelado turnoCancelado) {
        if (turnoCancelado == null) {
            notFound()
            return
        }

        try {
            turnoCanceladoService.save(turnoCancelado)
        } catch (ValidationException e) {
            respond turnoCancelado.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'turnoCancelado.label', default: 'TurnoCancelado'), turnoCancelado.id])
                redirect turnoCancelado
            }
            '*'{ respond turnoCancelado, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        turnoCanceladoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'turnoCancelado.label', default: 'TurnoCancelado'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'turnoCancelado.label', default: 'TurnoCancelado'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
