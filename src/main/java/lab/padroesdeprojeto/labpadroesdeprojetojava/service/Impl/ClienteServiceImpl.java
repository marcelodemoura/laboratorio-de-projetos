package lab.padroesdeprojeto.labpadroesdeprojetojava.service.Impl;

import lab.padroesdeprojeto.labpadroesdeprojetojava.model.Cliente;
import lab.padroesdeprojeto.labpadroesdeprojetojava.model.ClienteRepository;
import lab.padroesdeprojeto.labpadroesdeprojetojava.model.Endereco;
import lab.padroesdeprojeto.labpadroesdeprojetojava.model.EnderecoRepository;
import lab.padroesdeprojeto.labpadroesdeprojetojava.service.ClienteService;
import lab.padroesdeprojeto.labpadroesdeprojetojava.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscaPorId(long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        cliente.setNome(cliente.getNome());
        cliente.setEndereco(cliente.getEndereco());
        clienteRepository.save(cliente);
//        SalvarClienteComCep(cliente);
        return cliente;

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            SalvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
    private void SalvarClienteComCep(Cliente cliente) {
        Optional<Endereco> cep = enderecoRepository.findById(cliente.getEndereco().getCep());
        Endereco endereco = enderecoRepository.findById(String.valueOf(cep)).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultaCep(String.valueOf(cep));
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
