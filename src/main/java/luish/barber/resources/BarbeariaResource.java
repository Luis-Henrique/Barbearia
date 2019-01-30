/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.resources;

import java.util.List;
import java.util.stream.Collectors;
import javassist.tools.rmi.ObjectNotFoundException;
import javax.validation.Valid;
import luish.barber.dto.BarbeariaDTO;
import luish.barber.entidades.Barbearia;
import luish.barber.services.BarbeariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author luis
 */
@RestController
@RequestMapping(value = "/barbearias")
public class BarbeariaResource {

    @Autowired
    BarbeariaService barbeariaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BarbeariaDTO> update(@Valid @RequestBody BarbeariaDTO objDTO, @PathVariable Integer id) throws ObjectNotFoundException {

        Barbearia obj = barbeariaService.fromDTO(objDTO);
        obj.setId(id);
        obj = barbeariaService.update(obj);
        return ResponseEntity.noContent().build();

    }
    
     @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BarbeariaDTO>> findAll() {

        List<Barbearia> list = barbeariaService.findAll();
        List<BarbeariaDTO> listDto = list.stream().map(obj -> new BarbeariaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
    
    
    
}
