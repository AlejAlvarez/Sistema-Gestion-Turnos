package sistematurnos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InformacionUsuarioServiceSpec extends Specification {

    InformacionUsuarioService informacionUsuarioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new InformacionUsuario(...).save(flush: true, failOnError: true)
        //new InformacionUsuario(...).save(flush: true, failOnError: true)
        //InformacionUsuario informacionUsuario = new InformacionUsuario(...).save(flush: true, failOnError: true)
        //new InformacionUsuario(...).save(flush: true, failOnError: true)
        //new InformacionUsuario(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //informacionUsuario.id
    }

    void "test get"() {
        setupData()

        expect:
        informacionUsuarioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<InformacionUsuario> informacionUsuarioList = informacionUsuarioService.list(max: 2, offset: 2)

        then:
        informacionUsuarioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        informacionUsuarioService.count() == 5
    }

    void "test delete"() {
        Long informacionUsuarioId = setupData()

        expect:
        informacionUsuarioService.count() == 5

        when:
        informacionUsuarioService.delete(informacionUsuarioId)
        sessionFactory.currentSession.flush()

        then:
        informacionUsuarioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        InformacionUsuario informacionUsuario = new InformacionUsuario()
        informacionUsuarioService.save(informacionUsuario)

        then:
        informacionUsuario.id != null
    }
}
