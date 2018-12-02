package sistematurnos

import grails.gorm.services.Service

@Service(HorarioLaboral)
interface HorarioLaboralService {

    HorarioLaboral get(Serializable id)

    List<HorarioLaboral> list(Map args)

    Long count()

    void delete(Serializable id)

    HorarioLaboral save(HorarioLaboral horarioLaboral)

}