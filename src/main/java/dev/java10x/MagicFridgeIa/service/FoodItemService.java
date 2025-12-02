package dev.java10x.MagicFridgeIa.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import dev.java10x.MagicFridgeIa.model.FoodItem;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import dev.java10x.MagicFridgeIa.repository.FoodItemRepository;

import java.util.List;
import java.util.Optional;

@Data
@Service
@RequiredArgsConstructor

public class FoodItemService {
    private final FoodItemRepository repository;


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
