package br.com.rd.ecommerce.Controller;
import br.com.rd.ecommerce.model.Address;
import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.model.ClientAddress;
import br.com.rd.ecommerce.repository.AddressRepository;
import br.com.rd.ecommerce.repository.ClientRepository;
import br.com.rd.ecommerce.repository.ClienteAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.websocket.server.PathParam;
import java.util.List;

@RestController

public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClienteAddressRepository clienteAddressRepository;
    @Autowired
    private AddressRepository addressRepository;
    @ResponseStatus(HttpStatus.CREATED)

    @PostMapping("/create-client")
    public ResponseEntity save(@RequestBody Client client){
        return ResponseEntity.ok().body(clientRepository.save(client));
    };

    @PostMapping("/esquecisenha")
    public ResponseEntity recuperar(@RequestBody String mail){
        Client client = clientRepository.findByMail(mail);
        return ResponseEntity.ok().body(client.getPassword());
    }

    @GetMapping("/find-client/list")
    public List<Client> find() {
        return clientRepository.findAll();
    }

    @GetMapping ("/find-client/{mail}")
    public  Client find(@PathVariable("mail")String mail ){return clientRepository.findByMail(mail);}

    @GetMapping("find-lastClient")
    public Long findLast(){return clientRepository.max();}

    @PostMapping("/login")
    public ResponseEntity  fazerLogin(@RequestBody() Client user){
        try {
             Client client = clientRepository.findByMail(user.getMail());
            if (client != null && client.getPassword().equals(user.getPassword())){
                System.out.println(client);
                return ResponseEntity.ok().body(client);
            } else {
                return ResponseEntity.ok().body("Email ou/e senha incorretos");
            }
        } catch (Exception e){
            String erro = "Não foi possivel autenticar tente novamente";
            return ResponseEntity.badRequest().body(erro);
        }
    }
    @PutMapping("/client")
    public Client alterar(@RequestBody Client client){
        Client clientEntity = clientRepository.getOne(client.getIdClient());
        clientEntity.setName(client.getName());
        clientEntity.setCpf(client.getCpf());
        clientEntity.setMail(client.getMail());
        clientEntity.setPassword(client.getPassword());
        clientEntity.setPhone(client.getPhone());
        clientEntity.setBirthDate(client.getBirthDate());
        return clientRepository.save(clientEntity);
    }
    }