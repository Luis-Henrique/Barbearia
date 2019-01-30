/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.resources;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javassist.tools.rmi.ObjectNotFoundException;
import javax.validation.Valid;
import luish.barber.dto.BarbeiroDTO;
import luish.barber.entidades.Barbeiro;
import luish.barber.entidades.Servico;
import luish.barber.services.BarbeiroService;
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
@RequestMapping(value = "/barbeiros")
public class BarbeiroResource {

    @Autowired
    BarbeiroService barbeiroService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Barbeiro> find(@PathVariable Integer id) throws ObjectNotFoundException {

        Barbeiro obj = barbeiroService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BarbeiroDTO>> findAll() {

        List<Barbeiro> list = barbeiroService.findAll();
        List<BarbeiroDTO> listDto = list.stream().map(obj -> new BarbeiroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(method = RequestMethod.POST)
    //resposta HTTP
    public ResponseEntity<BarbeiroDTO> insert(@Valid @RequestBody BarbeiroDTO objDto) {
        Barbeiro obj = barbeiroService.fromDTO(objDto);
        obj = barbeiroService.insert(obj);
        //pega uri e acrescenta /id
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Barbeiro> delete(@PathVariable Integer id) throws ObjectNotFoundException {

        barbeiroService.remove(id);
        return ResponseEntity.noContent().build();
    }

}
