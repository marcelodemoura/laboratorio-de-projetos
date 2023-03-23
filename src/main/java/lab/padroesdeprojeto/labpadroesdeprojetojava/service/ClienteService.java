package lab.padroesdeprojeto.labpadroesdeprojetojava.service;

import lab.padroesdeprojeto.labpadroesdeprojetojava.model.Cliente;

public interface ClienteService {
    Iterable<Cliente>buscarTodos();
    Cliente buscaPorId(long id);
    Cliente inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
