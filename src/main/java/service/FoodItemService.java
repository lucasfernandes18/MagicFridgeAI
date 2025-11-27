package service;

import lombok.Data;
import model.FoodItem;
import org.springframework.stereotype.Service;
import repository.FoodItemRepository;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class FoodItemService {
    private FoodItemRepository repository;


    //salvar
    public FoodItem salvar(FoodItem foodItem) {
        return repository.save(foodItem);
    }


    //listar
    public List<FoodItem> listar() {
        return repository.findAll();
    }


    //listarporid
    public Optional<FoodItem> listarPorId(Long id) {
        return repository.findById(id);
    }


    // deletar
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // atualizar
    public FoodItem atualizar(Long id, FoodItem atualizacao) {
        Optional<FoodItem> atual = repository.findById(id);
        if (atual.isPresent()) {
            FoodItem atualOpt = atual.get();
            atualOpt.setNome(atualizacao.getNome());
            atualOpt.setQuantidade(atualizacao.getQuantidade());
            atualOpt.setCategoria(atualizacao.getCategoria());
            atualOpt.setValidade(atualizacao.getValidade());

            return repository.save(atualOpt);

        }
        throw new RuntimeException("FoodItem não encontrado");
    }

}
