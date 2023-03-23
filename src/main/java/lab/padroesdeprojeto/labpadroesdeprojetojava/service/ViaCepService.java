package lab.padroesdeprojeto.labpadroesdeprojetojava.service;

import lab.padroesdeprojeto.labpadroesdeprojetojava.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacep",  url ="https:// viacep.cpm.br/ws")
public interface ViaCepService {
//    @RequestMapping (method = RequestMethod.GET, value = "/{cep}/json/")
//nessa situação tento RequestMapping quanto o @GetMapping tem o mesmo resultado.
    @GetMapping("/{cep}/json/")
        Endereco consultaCep(@PathVariable("cep")String cep);
}
