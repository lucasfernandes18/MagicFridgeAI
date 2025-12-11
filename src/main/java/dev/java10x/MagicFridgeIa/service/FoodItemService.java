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
import java.util.stream.Collectors;

@Data
@Service
@RequiredArgsConstructor

public class FoodItemService {
    private final FoodItemRepository repository;
    private final FoodMapper foodMapper;



    //criar
    public FoodDTO salvar(FoodDTO foodDTO) {
        FoodItem comida = foodMapper.map(foodDTO);
        comida = repository.save(comida);
        return foodMapper.map(comida);
    }


    //listar
    public List<FoodDTO> listar() {
        List<FoodItem> listaDeAlimentos = repository.findAll();
        return listaDeAlimentos.stream()
                .map(foodMapper::map)
                .collect(Collectors.toList());
    }


    //listarporid
    public FoodDTO listarPorId(Long id) {
        Optional<FoodItem> foodItem = repository.findById(id);
        return foodItem.map(foodMapper::map).orElse(null);

    }


    // deletar
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // atualizar
    public FoodDTO atualizar(Long id, FoodDTO atualizacao) {
        Optional<FoodItem> atual = repository.findById(id);
       if (atual.isPresent()) {
            FoodItem atualOpt = atual.get();
            atualOpt.setNome(atualizacao.getNome());
            atualOpt.setQuantidade(atualizacao.getQuantidade());
            atualOpt.setCategoria(atualizacao.getCategoria());
            atualOpt.setValidade(atualizacao.getValidade());



            return foodMapper.map(atualOpt);

        }
        throw new RuntimeException("FoodItem não encontrado");
    }

}
