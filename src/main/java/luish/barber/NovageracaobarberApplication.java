package luish.barber;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import luish.barber.entidades.Agendamento;
import luish.barber.entidades.Barbearia;
import luish.barber.entidades.Barbeiro;
import luish.barber.entidades.Cliente;
import luish.barber.entidades.Servico;
import luish.barber.entidades.enuns.Perfil;
import luish.barber.entidades.enuns.TipoServico;
import luish.barber.repository.AgendamentoRepository;
import luish.barber.repository.BarbeariaRepository;
import luish.barber.repository.BarbeiroRepository;
import luish.barber.repository.ClienteRepository;
import luish.barber.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class NovageracaobarberApplication implements CommandLineRunner {
    
    @Autowired
    BCryptPasswordEncoder pe;

    @Autowired
    ClienteRepository cliente;

    @Autowired
    ServicoRepository servico;

    @Autowired
    BarbeiroRepository barbeiroRepository;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Autowired
    BarbeariaRepository barbeariaRepository;

    public static void main(String[] args) {

        SpringApplication.run(NovageracaobarberApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        Date d = new Date();

        Cliente c = new Cliente(null, "luis", "123", d, "luis@gmail", pe.encode("123"));
        Cliente c2 = new Cliente(null, "Henrique", "456", d, "henrique@gmail", pe.encode("123"));
        c2.addPerfil(Perfil.ADMIN);
        Barbeiro b1 = new Barbeiro(null, "Edson");
        Barbeiro b2 = new Barbeiro(null, "Frederico");
        Servico s = new Servico(null, TipoServico.CORTE_TESOURA_DEGRADE, 18.00);
        Servico s2 = new Servico(null, TipoServico.CORTE_TESOURA_BARBA, 30.00);
        Servico s3 = new Servico(null, TipoServico.CORTE_MAQUINA, 10.00);
        Servico s4 = new Servico(null, TipoServico.CORTE_MAQUINA_DEGRADE, 12.00);
        Servico s5 = new Servico(null, TipoServico.CORTE_BARBA_MAQUINA, 10.00);
        Servico s6 = new Servico(null, TipoServico.CORTE_BARBA_NAVALHA, 15.00);
        Agendamento ag1 = new Agendamento(null, d, c, b2, s);
        Agendamento ag2 = new Agendamento(null, d, c2, b1, s2);
        Agendamento ag3 = new Agendamento(null, d, c2, b1, s2);

        Barbearia bar1 = new Barbearia(null, "Jerônimo Timóteo da Fonseca", "280", "Rio Grande do Sul", "Gravataí",
                "8:00 às 21:30", "8:00 às 21:30", "8:00 às 21:30", "8:00 às 21:30", "8:00 às 21:30", "8:00 às 21:30");
        
        bar1.getTelefones().addAll(Arrays.asList("34884082","993450827", "985220074", "996551269"));

        c.getAgendamentos().addAll(Arrays.asList(ag1));
        c2.getAgendamentos().addAll(Arrays.asList(ag2,ag3));
        cliente.save(Arrays.asList(c, c2));

        s.getBarbeiros().addAll(Arrays.asList(b1, b2));
        s2.getBarbeiros().addAll(Arrays.asList(b1));
        s3.getBarbeiros().addAll(Arrays.asList(b2));
        s.getAgendamentos().addAll(Arrays.asList(ag1, ag2, ag3));
        s2.getAgendamentos().addAll(Arrays.asList(ag1));
        s3.getAgendamentos().addAll(Arrays.asList(ag1));
        servico.save(Arrays.asList(s, s2, s3, s4, s5, s6));

        b1.getAgendamentos().addAll(Arrays.asList(ag1, ag2, ag3));
        b2.getAgendamentos().addAll(Arrays.asList(ag1));
        b1.getServicos().addAll(Arrays.asList(s, s2, s3, s4, s5, s6));
        b2.getServicos().addAll(Arrays.asList(s, s2, s3, s4, s5, s6));
        barbeiroRepository.save(Arrays.asList(b1, b2));

        agendamentoRepository.save(Arrays.asList(ag1, ag2, ag3));
        
        barbeariaRepository.save(bar1);

    }

}
