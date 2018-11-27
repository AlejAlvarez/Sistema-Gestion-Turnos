package sistematurnos

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TurnoCanceladoServiceSpec extends Specification {

    TurnoCanceladoService turnoCanceladoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TurnoCancelado(...).save(flush: true, failOnError: true)
        //new TurnoCancelado(...).save(flush: true, failOnError: true)
        //TurnoCancelado turnoCancelado = new TurnoCancelado(...).save(flush: true, failOnError: true)
        //new TurnoCancelado(...).save(flush: true, failOnError: true)
        //new TurnoCancelado(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //turnoCancelado.id
    }

    void "test get"() {
        setupData()

        expect:
        turnoCanceladoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TurnoCancelado> turnoCanceladoList = turnoCanceladoService.list(max: 2, offset: 2)

        then:
        turnoCanceladoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        turnoCanceladoService.count() == 5
    }

    void "test delete"() {
        Long turnoCanceladoId = setupData()

        expect:
        turnoCanceladoService.count() == 5

        when:
        turnoCanceladoService.delete(turnoCanceladoId)
        sessionFactory.currentSession.flush()

        then:
        turnoCanceladoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TurnoCancelado turnoCancelado = new TurnoCancelado()
        turnoCanceladoService.save(turnoCancelado)

        then:
        turnoCancelado.id != null
    }
}
