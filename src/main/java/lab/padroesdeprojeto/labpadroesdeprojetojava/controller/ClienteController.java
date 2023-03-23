package lab.padroesdeprojeto.labpadroesdeprojetojava.controller;

import lab.padroesdeprojeto.labpadroesdeprojetojava.model.Cliente;
import lab.padroesdeprojeto.labpadroesdeprojetojava.service.ClienteService;
import lab.padroesdeprojeto.labpadroesdeprojetojava.service.Impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteserviceImpl;

    @GetMapping
    public ResponseEntity buscarTodos() {
        return ResponseEntity.ok(clienteserviceImpl.buscarTodos());
    }
//    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
//        return ResponseEntity.ok(clienteService.buscarTodos());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteserviceImpl.buscaPorId(id));
    }
    @PostMapping
    public ResponseEntity<Cliente>inserir(@RequestBody Cliente cliente){
        cliente.setNome(cliente.getNome());
        cliente.setEndereco(cliente.getEndereco());

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteserviceImpl.inserir(cliente));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente>atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteserviceImpl.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletar(@PathVariable Long id){
        clienteserviceImpl.deletar(id);
        return ResponseEntity.ok().build();
    }

}
