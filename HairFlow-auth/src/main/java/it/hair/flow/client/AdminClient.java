package it.hair.flow.client;

import it.hair.flow.costant.Constant;
import it.hair.flow.dto.AdminDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "HAIRFLOW-ADMIN")
public interface AdminClient {

    @GetMapping("/admin/hair-flow/admin/{id}")
    AdminDTO findById(@PathVariable Integer id);


}
