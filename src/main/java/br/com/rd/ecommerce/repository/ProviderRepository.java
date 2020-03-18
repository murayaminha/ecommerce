package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    Provider findByCnpj(String cnpj);
    Provider findByName(String name);

}
