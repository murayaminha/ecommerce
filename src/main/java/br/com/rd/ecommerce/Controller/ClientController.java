package br.com.rd.ecommerce.Controller;
import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.repository.ClientRepository;
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
    @ResponseStatus(HttpStatus.CREATED)

    @PostMapping("/create-client")
    public Client save(@RequestBody Client client){
        return clientRepository.save(client);
    };

    @GetMapping("/find-client/list")
    public List<Client> find() {
        return clientRepository.findAll();
    }

    @GetMapping ("/find-client/{mail}")
    public  Client find(@PathVariable("mail")String mail ){return clientRepository.findByMail(mail);}

    @GetMapping("find-lastClient")
    public Long findLast(){return clientRepository.max();}

    @PostMapping("/login/{mail}/{password}")
    public ResponseEntity fazerLogin(@PathVariable("mail") String mail,
                                     @PathVariable("password") String password) {
        try {
            Client client = clientRepository.findByMail(mail);
            if (client != null && client.getPassword()==password){
                return ResponseEntity.ok().body(client);
            } else {
                return ResponseEntity.ok().body("Email ou/e senha incorretos");
            }
        } catch (Exception e){
            String erro = "Não foi possivel autenticar tente novamente";
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PostMapping("/teste/{mail}")
    public ResponseEntity fazerLogin(@PathVariable("mail") String mail){
        Client client = clientRepository.findByMail(mail);
        return ResponseEntity.ok().body(client);
    }
    }