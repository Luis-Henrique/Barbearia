/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.repository;

import java.io.Serializable;
import java.util.List;
import luish.barber.entidades.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author luis
 */
@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{

    
}
