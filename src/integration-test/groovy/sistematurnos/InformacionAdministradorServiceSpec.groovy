package sistematurnos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InformacionAdministradorServiceSpec extends Specification {

    InformacionAdministradorService informacionAdministradorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new InformacionAdministrador(...).save(flush: true, failOnError: true)
        //new InformacionAdministrador(...).save(flush: true, failOnError: true)
        //InformacionAdministrador informacionAdministrador = new InformacionAdministrador(...).save(flush: true, failOnError: true)
        //new InformacionAdministrador(...).save(flush: true, failOnError: true)
        //new InformacionAdministrador(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //informacionAdministrador.id
    }

    void "test get"() {
        setupData()

        expect:
        informacionAdministradorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<InformacionAdministrador> informacionAdministradorList = informacionAdministradorService.list(max: 2, offset: 2)

        then:
        informacionAdministradorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        informacionAdministradorService.count() == 5
    }

    void "test delete"() {
        Long informacionAdministradorId = setupData()

        expect:
        informacionAdministradorService.count() == 5

        when:
        informacionAdministradorService.delete(informacionAdministradorId)
        sessionFactory.currentSession.flush()

        then:
        informacionAdministradorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        InformacionAdministrador informacionAdministrador = new InformacionAdministrador()
        informacionAdministradorService.save(informacionAdministrador)

        then:
        informacionAdministrador.id != null
    }
}
