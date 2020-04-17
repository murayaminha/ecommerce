package br.com.rd.ecommerce.Controller;
import br.com.rd.ecommerce.model.Client;
import br.com.rd.ecommerce.model.CreditCard;
import br.com.rd.ecommerce.repository.CreditCardRepository;
import com.google.common.primitives.Bytes;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import static org.junit.Assert.assertArrayEquals;
@RestController
public class CreditCardController {
    @Autowired
    CreditCardRepository creditCardRepository;
    @PostMapping("salvarCartao")
    public ResponseEntity salvarCartao(@RequestBody CreditCard creditCard) {
        return ResponseEntity.ok().body(creditCardRepository.save(creditCard));
    }
    @PostMapping("puxarCartaoCliente")
    public ResponseEntity<?> pegarCard(@RequestBody Client client){
        CreditCard creditCard = creditCardRepository.findByClient(client);
        return ResponseEntity.ok().body(creditCard);
    }
    @PutMapping("alterarCartao")
    public ResponseEntity<?> alterar(@RequestBody CreditCard creditCard){
        Optional<CreditCard> creditCardOptional = creditCardRepository.findById(creditCard.getIdCreditCard());
        CreditCard creditCardAlterado = creditCardOptional.orElse(null);
        creditCardAlterado.setNumberCard(creditCard.getNumberCard());
        creditCardAlterado.setCpfTitular(creditCard.getCpfTitular());
        creditCardAlterado.setNomeTitular(creditCard.getNomeTitular());
        return ResponseEntity.ok().body(creditCardRepository.save(creditCardAlterado));
    }

}