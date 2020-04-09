package br.com.rd.ecommerce.Controller;


import br.com.rd.ecommerce.model.*;
import br.com.rd.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RequestController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RequestRepository repository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private StatusRequestRepository statusRequestRepository;


    @PostMapping("/request")
    public Request save(@RequestBody StatusRequest statusRequest){
        Request request = statusRequest.getRequest();
        request.setPayment(paymentRepository.save(request.getPayment()));
        statusRequest.setRequest(repository.save(request));
        statusRequestRepository.save(statusRequest);
        return request;
//    for(int i=0; i<request.getStatusRequest().size();i++){
//          StatusRequest status = statusRequestRepository.save(request.getStatusRequest().get(i));
//        System.out.println(status);
//          request.getStatusRequest().remove(i);
//           request.getStatusRequest().add(status);
//        System.out.println(request.getStatusRequest());
//    }
//        request.setPayment(paymentRepository.save(request.getPayment()));
//        return repository.save(request);
    }
    @GetMapping("/request/{id}")
    public Request findId(@PathVariable("id") Long id) { return repository.findById(id).get();
    }
    @DeleteMapping("/request")
    public void deletById(@PathVariable("id") Long id){
        repository.deleteById(id);
    }

    @PostMapping("/acompanhar")
    public ResponseEntity<List<Request>> acompanhar(@RequestBody() Client user){
            List request = repository.findByClient(user);
                return ResponseEntity.ok().body(request);
}
}
