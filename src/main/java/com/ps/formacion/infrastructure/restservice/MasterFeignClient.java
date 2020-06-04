package com.ps.formacion.infrastructure.restservice;

import com.ps.formacion.domain.Master;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "maestro", url = "172.x.x.x:8080")
public interface MasterFeignClient {

    @GetMapping("/{name}")
    public Master find(@PathVariable String name);
}
