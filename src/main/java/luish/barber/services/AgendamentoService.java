/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.services;

import java.util.Date;
import java.util.List;
import javassist.tools.rmi.ObjectNotFoundException;
import javax.swing.JOptionPane;
import luish.barber.dto.AgendamentoDTO;
import luish.barber.entidades.Agendamento;
import luish.barber.entidades.Barbeiro;
import luish.barber.entidades.Cliente;
import luish.barber.entidades.Servico;
import luish.barber.repository.AgendamentoRepository;
import luish.barber.repository.ClienteRepository;
import luish.barber.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Service
public class AgendamentoService {

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Autowired
    ClienteService clienteService;

    @Autowired
    BarbeiroService barbeiroService;

    @Autowired
    ServicoService servicoService;
    
    
    @Transactional
    public Agendamento insert(Agendamento obj) {
        obj.setId(null);
        agendamentoRepository.save(obj);
        return obj;
    }
   
    public Agendamento fromDTO(AgendamentoDTO objDTO) throws ObjectNotFoundException {

        
        Cliente c = clienteService.find(objDTO.getId_cliente());
        Barbeiro b = barbeiroService.find(objDTO.getId_barbeiro());
        Servico s = servicoService.find(objDTO.getId_servico());

        Agendamento a = new Agendamento(null,objDTO.getData(), c, b, s);
        return a;
    }

    boolean deleteAgendamento(Integer id) {

        List<Agendamento> a = agendamentoRepository.findAgendamentos(id);
        if (a != null) {
            delete(a);

            return true;
        }

        return false;
    }

    public void delete(List a) {
        agendamentoRepository.delete(a);

    }

}
