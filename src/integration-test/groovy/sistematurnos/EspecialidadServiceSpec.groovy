package sistematurnos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EspecialidadServiceSpec extends Specification {

    EspecialidadService especialidadService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Especialidad(...).save(flush: true, failOnError: true)
        //new Especialidad(...).save(flush: true, failOnError: true)
        //Especialidad especialidad = new Especialidad(...).save(flush: true, failOnError: true)
        //new Especialidad(...).save(flush: true, failOnError: true)
        //new Especialidad(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //especialidad.id
    }

    void "test get"() {
        setupData()

        expect:
        especialidadService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Especialidad> especialidadList = especialidadService.list(max: 2, offset: 2)

        then:
        especialidadList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        especialidadService.count() == 5
    }

    void "test delete"() {
        Long especialidadId = setupData()

        expect:
        especialidadService.count() == 5

        when:
        especialidadService.delete(especialidadId)
        sessionFactory.currentSession.flush()

        then:
        especialidadService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Especialidad especialidad = new Especialidad()
        especialidadService.save(especialidad)

        then:
        especialidad.id != null
    }
}
