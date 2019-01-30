/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.services;

import java.util.Date;
import javassist.tools.rmi.ObjectNotFoundException;
import javax.swing.JOptionPane;
import luish.barber.dto.ClienteNewDTO;
import luish.barber.dto.LoginDTO;
import luish.barber.entidades.Cliente;
import luish.barber.repository.ClienteRepository;
import luish.barber.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Service
public class ClienteService {

    @Autowired
    BCryptPasswordEncoder pe;
    
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente find(Integer id) throws ObjectNotFoundException {
        Cliente obj = clienteRepository.findOne(id);
        if (obj == null) {
            System.out.println("errouuuu");
        }
        return obj;
    }

    public Cliente fromDTO(ClienteNewDTO objDTO) {
        Date data = DateUtil.StringToDate(objDTO.getDataNascimento());
        Cliente cli = new Cliente(null, objDTO.getNome(), objDTO.getTelefone(), data, objDTO.getEmail(), pe.encode(objDTO.getSenha()));
        return cli;

    }

    @Transactional
    public Cliente insert(Cliente obj){
        obj.setId(null);
        clienteRepository.save(obj);
        return obj;
    }

    public Cliente update(Cliente obj) throws ObjectNotFoundException {
        Cliente newObj = find(obj.getId());
        updateCliente(obj, newObj);
        return clienteRepository.save(newObj);
    }

    private void updateCliente(Cliente obj, Cliente newObj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
        newObj.setTelefone(obj.getTelefone());
    }
    
}
