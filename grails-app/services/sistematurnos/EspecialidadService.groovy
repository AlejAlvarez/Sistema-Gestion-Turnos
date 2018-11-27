package sistematurnos

import grails.gorm.services.Service

@Service(Especialidad)
interface EspecialidadService {

    Especialidad get(Serializable id)

    List<Especialidad> list(Map args)

    Long count()

    void delete(Serializable id)

    Especialidad save(Especialidad especialidad)

}