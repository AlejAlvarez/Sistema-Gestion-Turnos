package sistematurnos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class InformacionUsuarioController {

    InformacionUsuarioService informacionUsuarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond informacionUsuarioService.list(params), model:[informacionUsuarioCount: informacionUsuarioService.count()]
    }

    def show(Long id) {
        respond informacionUsuarioService.get(id)
    }

    def create() {
        respond new InformacionUsuario(params)
    }

    def save(InformacionUsuario informacionUsuario) {
        if (informacionUsuario == null) {
            notFound()
            return
        }

        try {
            informacionUsuarioService.save(informacionUsuario)
        } catch (ValidationException e) {
            respond informacionUsuario.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'informacionUsuario.label', default: 'InformacionUsuario'), informacionUsuario.id])
                redirect informacionUsuario
            }
            '*' { respond informacionUsuario, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond informacionUsuarioService.get(id)
    }

    def update(InformacionUsuario informacionUsuario) {
        if (informacionUsuario == null) {
            notFound()
            return
        }

        try {
            informacionUsuarioService.save(informacionUsuario)
        } catch (ValidationException e) {
            respond informacionUsuario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'informacionUsuario.label', default: 'InformacionUsuario'), informacionUsuario.id])
                redirect informacionUsuario
            }
            '*'{ respond informacionUsuario, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        informacionUsuarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'informacionUsuario.label', default: 'InformacionUsuario'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'informacionUsuario.label', default: 'InformacionUsuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
