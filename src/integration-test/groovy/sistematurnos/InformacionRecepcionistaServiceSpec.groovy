package sistematurnos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InformacionRecepcionistaServiceSpec extends Specification {

    InformacionRecepcionistaService informacionRecepcionistaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new InformacionRecepcionista(...).save(flush: true, failOnError: true)
        //new InformacionRecepcionista(...).save(flush: true, failOnError: true)
        //InformacionRecepcionista informacionRecepcionista = new InformacionRecepcionista(...).save(flush: true, failOnError: true)
        //new InformacionRecepcionista(...).save(flush: true, failOnError: true)
        //new InformacionRecepcionista(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //informacionRecepcionista.id
    }

    void "test get"() {
        setupData()

        expect:
        informacionRecepcionistaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<InformacionRecepcionista> informacionRecepcionistaList = informacionRecepcionistaService.list(max: 2, offset: 2)

        then:
        informacionRecepcionistaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        informacionRecepcionistaService.count() == 5
    }

    void "test delete"() {
        Long informacionRecepcionistaId = setupData()

        expect:
        informacionRecepcionistaService.count() == 5

        when:
        informacionRecepcionistaService.delete(informacionRecepcionistaId)
        sessionFactory.currentSession.flush()

        then:
        informacionRecepcionistaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        InformacionRecepcionista informacionRecepcionista = new InformacionRecepcionista()
        informacionRecepcionistaService.save(informacionRecepcionista)

        then:
        informacionRecepcionista.id != null
    }
}
