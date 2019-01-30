/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.services;


import java.util.List;
import javassist.tools.rmi.ObjectNotFoundException;
import luish.barber.dto.BarbeiroDTO;
import luish.barber.entidades.Barbeiro;
import luish.barber.entidades.Servico;
import luish.barber.repository.BarbeiroRepository;
import luish.barber.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis
 */
@Service
public class BarbeiroService {

    @Autowired
    BarbeiroRepository barbeiroRepository;
    
    @Autowired
    ServicoRepository servicoRepository;

    @Autowired
    AgendamentoService agendamentoService;
    
    public Barbeiro find(Integer id) throws ObjectNotFoundException {

        Barbeiro obj = barbeiroRepository.findOne(id);
        return obj;
    }

    public List<Barbeiro> findAll() {
        List<Barbeiro> obj = barbeiroRepository.findAll();
        return obj;
    }

    public Barbeiro fromDTO(BarbeiroDTO objDto) {
        Barbeiro b = new Barbeiro(objDto.getId(), objDto.getNome());
        b.getServicos().addAll(objDto.getServicos());
        return b;
    }

    public Barbeiro insert(Barbeiro obj) {
        obj.setId(null);
        return barbeiroRepository.save(obj);
        
    }

    public void remove(int id) throws ObjectNotFoundException {
        Barbeiro obj = find(id);
        if(agendamentoService.deleteAgendamento(obj.getId())){
        barbeiroRepository.delete(obj);
        }
    }
}
