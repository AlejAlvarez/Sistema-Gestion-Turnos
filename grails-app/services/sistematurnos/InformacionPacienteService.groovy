package sistematurnos

import grails.gorm.services.Service

@Service(InformacionPaciente)
interface InformacionPacienteService {

    InformacionPaciente get(Serializable id)

    List<InformacionPaciente> list(Map args)

    Long count()

    void delete(Serializable id)

    InformacionPaciente save(InformacionPaciente informacionPaciente)

}