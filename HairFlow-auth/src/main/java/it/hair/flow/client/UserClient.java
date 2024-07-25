package it.hair.flow.client;

import it.hair.flow.dto.UtenteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HAIRFLOW-USER")
public interface UserClient {

    @GetMapping("/user/hair-flow/user/{id}")
    UtenteDTO findById(@PathVariable Integer id);

}
