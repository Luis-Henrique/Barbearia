/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.services;

import java.util.List;
import javassist.tools.rmi.ObjectNotFoundException;
import luish.barber.dto.BarbeariaDTO;
import luish.barber.entidades.Barbearia;
import luish.barber.repository.BarbeariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis
 */
@Service
public class BarbeariaService {

    @Autowired
    BarbeariaRepository barbeariaRepository;

    public Barbearia find(Integer id) throws ObjectNotFoundException {
        Barbearia obj = barbeariaRepository.findOne(id);
        if (obj == null) {
            System.out.println("errouuuu");
        }
        return obj;
    }

    public Barbearia fromDTO(BarbeariaDTO objDTO) {
        Barbearia b = new Barbearia(null, objDTO.getRua(), objDTO.getNumero(), objDTO.getEstado(),
                objDTO.getCidade(), objDTO.getHoraSegunda(), objDTO.getHoraTerca(), objDTO.getHoraQuarta(),
                objDTO.getHoraQuinta(), objDTO.getHoraSexta(), objDTO.getHoraSabado());

        b.getTelefones().add(objDTO.getTelefone1());
        if (objDTO.getTelefone2() != null) {
            b.getTelefones().add(objDTO.getTelefone2());
        }
        if (objDTO.getTelefone3() != null) {
            b.getTelefones().add(objDTO.getTelefone3());
        }
        
        if (objDTO.getTelefone4() != null) {
            b.getTelefones().add(objDTO.getTelefone4());
        }

        return b;
    }

    public Barbearia update(Barbearia obj) throws ObjectNotFoundException {
        Barbearia newObj = find(obj.getId());
        updateBarbearia(obj, newObj);
        return barbeariaRepository.save(newObj);
    }

    private void updateBarbearia(Barbearia obj, Barbearia newObj) {
        newObj.setRua(obj.getRua());
        newObj.setNumero(obj.getNumero());
        newObj.setEstado(obj.getEstado());
        newObj.setCidade(obj.getCidade());
        newObj.setTelefones(obj.getTelefones());
        newObj.setHoraSegunda(obj.getHoraSegunda());
        newObj.setHoraTerca(obj.getHoraTerca());
        newObj.setHoraQuarta(obj.getHoraQuarta());
        newObj.setHoraQuinta(obj.getHoraQuinta());
        newObj.setHoraSexta(obj.getHoraSexta());
        newObj.setHoraSabado(obj.getHoraSabado());

    }

    public List<Barbearia> findAll() {

        List<Barbearia> obj = barbeariaRepository.findAll();
        return obj;
    }

}
