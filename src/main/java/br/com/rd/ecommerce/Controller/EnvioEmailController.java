package br.com.rd.ecommerce.Controller;

import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;

@RestController
public class EnvioEmailController {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private ClientRepository clientRepository;
    @PostMapping("/email-send")
    public ResponseEntity<?> restaurarSenha(@RequestBody String email){
        Client client = clientRepository.findByMail(email);
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper( mail );
            helper.setTo( email );
            helper.setSubject( "Solicitação de recuperação de senha." );
            helper.setText("<p>Olá!<br> <br>Você solicitou a recuperação de senha!</p>Sua senha é: "
                    +client.getPassword()+"<p>Caso não tenha solicitado, nós responda neste email</p>", true);
            mailSender.send(mail);
             return  ResponseEntity.ok().body("email enviado");
        } catch (Exception e) {
            e.printStackTrace();
        return ResponseEntity.ok().body("email enviado");
        }
    }
}

