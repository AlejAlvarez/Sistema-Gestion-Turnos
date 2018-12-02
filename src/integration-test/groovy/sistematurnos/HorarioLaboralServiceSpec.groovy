package sistematurnos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HorarioLaboralServiceSpec extends Specification {

    HorarioLaboralService horarioLaboralService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new HorarioLaboral(...).save(flush: true, failOnError: true)
        //new HorarioLaboral(...).save(flush: true, failOnError: true)
        //HorarioLaboral horarioLaboral = new HorarioLaboral(...).save(flush: true, failOnError: true)
        //new HorarioLaboral(...).save(flush: true, failOnError: true)
        //new HorarioLaboral(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //horarioLaboral.id
    }

    void "test get"() {
        setupData()

        expect:
        horarioLaboralService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<HorarioLaboral> horarioLaboralList = horarioLaboralService.list(max: 2, offset: 2)

        then:
        horarioLaboralList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        horarioLaboralService.count() == 5
    }

    void "test delete"() {
        Long horarioLaboralId = setupData()

        expect:
        horarioLaboralService.count() == 5

        when:
        horarioLaboralService.delete(horarioLaboralId)
        sessionFactory.currentSession.flush()

        then:
        horarioLaboralService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        HorarioLaboral horarioLaboral = new HorarioLaboral()
        horarioLaboralService.save(horarioLaboral)

        then:
        horarioLaboral.id != null
    }
}
