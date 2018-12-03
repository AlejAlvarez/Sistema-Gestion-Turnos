package sistematurnos

import grails.gorm.services.Service

@Service(InformacionRecepcionista)
interface InformacionRecepcionistaService {

    InformacionRecepcionista get(Serializable id)

    List<InformacionRecepcionista> list(Map args)

    Long count()

    void delete(Serializable id)

    InformacionRecepcionista save(InformacionRecepcionista informacionRecepcionista)

}