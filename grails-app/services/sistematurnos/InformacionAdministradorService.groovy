package sistematurnos

import grails.gorm.services.Service

@Service(InformacionAdministrador)
interface InformacionAdministradorService {

    InformacionAdministrador get(Serializable id)

    List<InformacionAdministrador> list(Map args)

    Long count()

    void delete(Serializable id)

    InformacionAdministrador save(InformacionAdministrador informacionAdministrador)

}