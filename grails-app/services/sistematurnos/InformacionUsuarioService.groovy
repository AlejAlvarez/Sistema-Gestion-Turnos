package sistematurnos

import grails.gorm.services.Service

@Service(InformacionUsuario)
interface InformacionUsuarioService {

    InformacionUsuario get(Serializable id)

    List<InformacionUsuario> list(Map args)

    Long count()

    void delete(Serializable id)

    InformacionUsuario save(InformacionUsuario informacionUsuario)

}