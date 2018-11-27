package sistematurnos

import grails.gorm.services.Service

@Service(TurnoCancelado)
interface TurnoCanceladoService {

    TurnoCancelado get(Serializable id)

    List<TurnoCancelado> list(Map args)

    Long count()

    void delete(Serializable id)

    TurnoCancelado save(TurnoCancelado turnoCancelado)

}