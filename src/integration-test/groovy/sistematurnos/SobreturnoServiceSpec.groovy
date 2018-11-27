package sistematurnos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SobreturnoServiceSpec extends Specification {

    SobreturnoService sobreturnoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Sobreturno(...).save(flush: true, failOnError: true)
        //new Sobreturno(...).save(flush: true, failOnError: true)
        //Sobreturno sobreturno = new Sobreturno(...).save(flush: true, failOnError: true)
        //new Sobreturno(...).save(flush: true, failOnError: true)
        //new Sobreturno(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sobreturno.id
    }

    void "test get"() {
        setupData()

        expect:
        sobreturnoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Sobreturno> sobreturnoList = sobreturnoService.list(max: 2, offset: 2)

        then:
        sobreturnoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sobreturnoService.count() == 5
    }

    void "test delete"() {
        Long sobreturnoId = setupData()

        expect:
        sobreturnoService.count() == 5

        when:
        sobreturnoService.delete(sobreturnoId)
        sessionFactory.currentSession.flush()

        then:
        sobreturnoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Sobreturno sobreturno = new Sobreturno()
        sobreturnoService.save(sobreturno)

        then:
        sobreturno.id != null
    }
}
