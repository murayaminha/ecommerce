package br.com.rd.ecommerce.Repository;


        import br.com.rd.ecommerce.model.Client;
        import br.com.rd.ecommerce.repository.ClientRepository;
        import org.assertj.core.api.Assertions;
        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.rules.ExpectedException;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import org.springframework.test.context.junit4.SpringRunner;


        import javax.validation.ConstraintViolationException;
        import java.util.Arrays;
        import java.util.Date;
        import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void adicionarNovoRegistro() {

        Client client = new Client();
        client.setPhone("1121551421");
        client.setMail("lu@teste.com");
        client.setCpf("43243256714");
        client.setName("Luciana");
        client.setPassword("24156214654");

        Client clientPersitido = clientRepository.save(client);

        Assertions.assertThat(clientPersitido.getIdClient()).isNotNull();
        Assertions.assertThat(clientPersitido.getPhone()).isEqualTo(client.getPhone());
        Assertions.assertThat(clientPersitido.getMail()).isEqualTo(client.getMail());
        Assertions.assertThat(clientPersitido.getCpf()).isEqualTo(client.getCpf());
        Assertions.assertThat(clientPersitido.getPassword()).isEqualTo(client.getPassword());
        Assertions.assertThat(clientPersitido.getName()).isEqualTo(client.getName());

    }

    @Test
    public void adicionarNovoRegistroSemNomeDeveDispararValidationErro() {
//        thrown.expect(ConstraintViolationException.class);


        Client client = new Client();
        client.setPhone("1121551421");
        client.setMail("lu@teste.com");
        client.setCpf("43243256714");
        client.setName("Luciana");
        client.setPassword("24156214654");

        Client clientPersitido = clientRepository.save(client);


    }

    @Test
    public void excluirRegistro() {


        Client client = new Client();
        client.setPhone("1121551421");
        client.setMail("lu@teste.com");
        client.setCpf("43243256714");
        client.setName("Luciana");
        client.setPassword("24156214654");

        Client clientPersitido = clientRepository.save(client);

        clientRepository.delete(clientPersitido);
    }

    @Test
    public void atualizarRegistro() {

        Client client = new Client();
        client.setPhone("1121551421");
        client.setMail("lu@teste.com");
        client.setCpf("43243256714");
        client.setName("Luciana");
        client.setPassword("24156214654");

        clientRepository.save(client);

        client.setName("Lucina 2");
        Client clientAtualizado = clientRepository.save(client);

        Assertions.assertThat(clientAtualizado.getIdClient()).isNotNull();
        Assertions.assertThat(clientAtualizado.getPhone()).isEqualTo(client.getPhone());
        Assertions.assertThat(clientAtualizado.getMail()).isEqualTo(client.getMail());
        Assertions.assertThat(clientAtualizado.getCpf()).isEqualTo(client.getCpf());
        Assertions.assertThat(clientAtualizado.getPassword()).isEqualTo(client.getPassword());
        Assertions.assertThat(clientAtualizado.getName()).isEqualTo(client.getName());
    }
}