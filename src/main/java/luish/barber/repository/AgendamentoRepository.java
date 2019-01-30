/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luish.barber.repository;

import java.io.Serializable;
import java.util.List;
import luish.barber.entidades.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luis
 */
@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>{
    
    @Transactional(readOnly = true)
    @Query("SELECT obj FROM Agendamento obj WHERE obj.barbeiro.id = :id")
    public List<Agendamento> findAgendamentos(@Param("id")Integer id_barbeiro);
    
}




