package it.hair.flow.client;

import it.hair.flow.dto.AdminDTO;
import it.hair.flow.dto.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HAIRFLOW-CLIENT")
public interface ClientClient {

    @GetMapping("/client/hair-flow/client/{id}")
    ClienteDTO findById(@PathVariable Integer id);

}
