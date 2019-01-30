/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.resources;

import java.net.URI;
import javassist.tools.rmi.ObjectNotFoundException;
import javax.validation.Valid;
import luish.barber.dto.AgendamentoDTO;
import luish.barber.entidades.Agendamento;
import luish.barber.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author luis
 */
@RestController
@RequestMapping(value= "/agendamentos")
public class AgendamentoResource {
    
    @Autowired
    AgendamentoService agendamentoService;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AgendamentoDTO> insert(@RequestBody AgendamentoDTO objDTO) throws ObjectNotFoundException {

        Agendamento obj = agendamentoService.fromDTO(objDTO);
        obj = agendamentoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
    
}
