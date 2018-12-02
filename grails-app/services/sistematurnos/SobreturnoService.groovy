package sistematurnos

import grails.gorm.services.Service

@Service(Sobreturno)
interface SobreturnoService {

    Sobreturno get(Serializable id)

    List<Sobreturno> list(Map args)

    Long count()

    void delete(Serializable id)

    Sobreturno save(Sobreturno sobreturno)

}