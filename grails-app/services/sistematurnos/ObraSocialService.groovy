package sistematurnos

import grails.gorm.services.Service

@Service(ObraSocial)
interface ObraSocialService {

    ObraSocial get(Serializable id)

    List<ObraSocial> list(Map args)

    Long count()

    void delete(Serializable id)

    ObraSocial save(ObraSocial obraSocial)

}