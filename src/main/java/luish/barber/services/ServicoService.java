/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.services;

import java.util.List;
import javassist.tools.rmi.ObjectNotFoundException;
import luish.barber.dto.ServicoDTO;
import luish.barber.dto.ServicoNewDTO;
import luish.barber.entidades.Servico;
import luish.barber.entidades.enuns.TipoServico;
import luish.barber.repository.BarbeiroRepository;
import luish.barber.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Service
public class ServicoService {

    @Autowired
    ServicoRepository servicoRepository;
    
      public Servico find(Integer id) throws ObjectNotFoundException {
        Servico obj = servicoRepository.findOne(id);
        if (obj == null) {
            System.out.println("errouuuu");
        }
        return obj;
    }

    public List<Servico> findAll() {
        List<Servico> obj = servicoRepository.findAll();
        return obj;
    }

    public Servico fromDTO(ServicoDTO objDTO) {
        //tentar ajeitar  q
        Servico s = new Servico(null, TipoServico.CORTE_MAQUINA_DEGRADE, objDTO.getValor());
        return s;
    }

    @Transactional
    public Servico insert(Servico obj) {
        obj.setId(null);
        servicoRepository.save(obj);
        return obj;
    }

    public Servico fromDTO(ServicoNewDTO objDTO) {
        Servico s = new Servico(null, null, objDTO.getValor());
        return s;
    }
    
       public Servico update(Servico obj) throws ObjectNotFoundException {
        Servico newObj = find(obj.getId());
        updateServico(obj, newObj);
        return servicoRepository.save(newObj);
    }

    private void updateServico(Servico obj, Servico newObj) {
        newObj.setValor(obj.getValor());
        newObj.setValorCartao(obj.getValorCartao());
        
    }

}
