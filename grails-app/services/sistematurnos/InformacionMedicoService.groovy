package sistematurnos

import grails.gorm.services.Service

@Service(InformacionMedico)
interface InformacionMedicoService {

    InformacionMedico get(Serializable id)

    List<InformacionMedico> list(Map args)

    Long count()

    void delete(Serializable id)

    InformacionMedico save(InformacionMedico informacionMedico)

}