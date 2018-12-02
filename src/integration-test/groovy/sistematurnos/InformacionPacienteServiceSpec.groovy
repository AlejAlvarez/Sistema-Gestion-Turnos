package sistematurnos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InformacionPacienteServiceSpec extends Specification {

    InformacionPacienteService informacionPacienteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new InformacionPaciente(...).save(flush: true, failOnError: true)
        //new InformacionPaciente(...).save(flush: true, failOnError: true)
        //InformacionPaciente informacionPaciente = new InformacionPaciente(...).save(flush: true, failOnError: true)
        //new InformacionPaciente(...).save(flush: true, failOnError: true)
        //new InformacionPaciente(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //informacionPaciente.id
    }

    void "test get"() {
        setupData()

        expect:
        informacionPacienteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<InformacionPaciente> informacionPacienteList = informacionPacienteService.list(max: 2, offset: 2)

        then:
        informacionPacienteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        informacionPacienteService.count() == 5
    }

    void "test delete"() {
        Long informacionPacienteId = setupData()

        expect:
        informacionPacienteService.count() == 5

        when:
        informacionPacienteService.delete(informacionPacienteId)
        sessionFactory.currentSession.flush()

        then:
        informacionPacienteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        InformacionPaciente informacionPaciente = new InformacionPaciente()
        informacionPacienteService.save(informacionPaciente)

        then:
        informacionPaciente.id != null
    }
}
