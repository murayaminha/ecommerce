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
//
//    static String IV = "AAAAAAAAAAAAAAAA";
//    static String chaveencriptacao = "0123456789abcdef";
//    @PostMapping("salvarCartao")
//    public ResponseEntity salvarCartao(@RequestBody CreditCard creditCard){
//        String textopuro = creditCard.getNumberCard();
//    try {
//        byte[] textoencriptado = encrypt(textopuro, chaveencriptacao);
//
//        for (byte b : textoencriptado) System.out.print((int) b + " ");
//        System.out.println("");
//        String texto =new String(textoencriptado,StandardCharsets.UTF_8);
//        creditCard.setNumberCard(texto);
//       return ResponseEntity.ok().body(creditCardRepository.save(creditCard));
//    } catch (Exception e) {
//        e.printStackTrace();
//        return ResponseEntity.badRequest().body("deu ruim");
//    }
//    }
//@GetMapping("puxarCartaoCliente")
//public ResponseEntity<?> pegarCard(@RequestBody Client client) throws UnsupportedEncodingException {
//        CreditCard creditCard = creditCardRepository.findByClient(client);
//        String numeroCartao = creditCard.getNumberCard();
//
//        byte[] bit = numeroCartao.getBytes(StandardCharsets.UTF_8);
//        try {
//            for (byte b : bit) System.out.print((int) b + " ");
//
//            System.out.println("");
//            creditCard.setNumberCard(decrypt(bit,chaveencriptacao));
//            return ResponseEntity.ok().body(creditCard);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body("deu ruim");
//        }
//}
//    public static byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
//        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
//        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes(StandardCharsets.UTF_8), "AES");
//        encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8)));
//        return encripta.doFinal(textopuro.getBytes(StandardCharsets.UTF_8));
//    }
//    public static String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception{
//        Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
//        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes(StandardCharsets.UTF_8), "AES");
//        decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8)));
//        return new String(decripta.doFinal(textoencriptado), StandardCharsets.UTF_8);
//    }

//    private static String chaveSimetrica;
//    private static String mensagem;
//    private static SecretKey key;
//    private static byte[] mensagemEncriptada;
//    private static byte[] mensagemDescriptada;
//    @PostMapping("salvarCartao")
//    public ResponseEntity salvarCartao(@RequestBody CreditCard creditCard){
//
//        chaveSimetrica = "asdfghjiolkqwert";
//        key = new SecretKeySpec(chaveSimetrica.getBytes(), "AES");
//
//        try {
//            Cipher cipher = Cipher.getInstance("AES");
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//            System.out.println("Informe sua mensagem a ser encriptada: ");
//            mensagem = creditCard.getNumberCard();
//            System.out.println(mensagem);
//            /* Encripta a Mensagem */
//            mensagemEncriptada = cipher.doFinal(mensagem.getBytes());
//
//            /* Exibe Mensagem Encriptada */
//            System.out.println(new String("Mensagem Encriptada: " + mensagemEncriptada));
//            String mensagemEncriptadaString = new String(mensagemEncriptada, "windows-1257");
//            creditCard.setNumberCard(mensagemEncriptadaString);
//            return ResponseEntity.ok().body(creditCardRepository.save(creditCard));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body("deu ruim criptografar");
//        }
//
//    }
//        @GetMapping("puxarCartaoCliente")
//public ResponseEntity<?> pegarCard(@RequestBody Client client) throws UnsupportedEncodingException {
//            CreditCard creditCard = creditCardRepository.findByClient(client);
//        String numeroCartao = creditCard.getNumberCard();
//    try {
//        Cipher cipher = Cipher.getInstance("AES");
//
//            mensagemEncriptada = numeroCartao.getBytes("windows-1257");
//            /* Informa ao objeto a ação de desencriptar */
//            cipher.init(Cipher.DECRYPT_MODE, key);
//
//            /* Recebe a mensagem encriptada e descripta */
//            mensagemDescriptada = cipher.doFinal(mensagemEncriptada);
//
//            /**
//             * Converte para a base 64 e amazena a mensagem em uma variavel
//             * auxiliar
//             */
//            String mensagemOriginal = new String(mensagemDescriptada);
//
//            /* Exibe Mensagem Descriptada */
//            System.out.println("Mensagem Descriptada: " + mensagemOriginal);
//            creditCard.setNumberCard(mensagemOriginal);
//            return ResponseEntity.ok().body(creditCard);
//        }
//		catch (Exception e) {
//        e.printStackTrace();
//        return ResponseEntity.badRequest().body("deu ruim descriptar");
//           }
//        }
//}


}
