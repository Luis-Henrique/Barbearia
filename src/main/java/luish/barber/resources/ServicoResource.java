/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javassist.tools.rmi.ObjectNotFoundException;
import javax.validation.Valid;
import luish.barber.dto.ServicoDTO;
import luish.barber.dto.ServicoNewDTO;
import luish.barber.entidades.Servico;
import luish.barber.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "/servicos")
public class ServicoResource {

    @Autowired
    ServicoService servicoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ServicoDTO>> findAll() {

        List<Servico> list = servicoService.findAll();
        List<ServicoDTO> listDto = list.stream().map(obj -> new ServicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ServicoDTO> insert(@Valid @RequestBody ServicoDTO objDTO) {

        Servico obj = servicoService.fromDTO(objDTO);
        obj = servicoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
    
      @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ServicoNewDTO> update(@Valid @RequestBody ServicoNewDTO objDTO, @PathVariable Integer id) throws ObjectNotFoundException {
        Servico obj = servicoService.fromDTO(objDTO);
        obj.setId(id);
        obj = servicoService.update(obj);
        return ResponseEntity.noContent().build();

    }
}
