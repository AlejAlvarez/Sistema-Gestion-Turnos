package sistematurnos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InformacionMedicoServiceSpec extends Specification {

    InformacionMedicoService informacionMedicoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new InformacionMedico(...).save(flush: true, failOnError: true)
        //new InformacionMedico(...).save(flush: true, failOnError: true)
        //InformacionMedico informacionMedico = new InformacionMedico(...).save(flush: true, failOnError: true)
        //new InformacionMedico(...).save(flush: true, failOnError: true)
        //new InformacionMedico(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //informacionMedico.id
    }

    void "test get"() {
        setupData()

        expect:
        informacionMedicoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<InformacionMedico> informacionMedicoList = informacionMedicoService.list(max: 2, offset: 2)

        then:
        informacionMedicoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        informacionMedicoService.count() == 5
    }

    void "test delete"() {
        Long informacionMedicoId = setupData()

        expect:
        informacionMedicoService.count() == 5

        when:
        informacionMedicoService.delete(informacionMedicoId)
        sessionFactory.currentSession.flush()

        then:
        informacionMedicoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        InformacionMedico informacionMedico = new InformacionMedico()
        informacionMedicoService.save(informacionMedico)

        then:
        informacionMedico.id != null
    }
}
