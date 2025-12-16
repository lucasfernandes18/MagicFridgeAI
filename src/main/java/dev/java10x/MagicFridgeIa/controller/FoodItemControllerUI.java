package dev.java10x.MagicFridgeIa.controller;

import dev.java10x.MagicFridgeIa.service.FoodDTO;
import dev.java10x.MagicFridgeIa.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/food/ui")
public class FoodItemControllerUI {

    private final FoodItemService foodItemService;

    // 1. O Principal: Carrega o Painel, a Lista e o Formulário Vazio
    @GetMapping("/painel")
    public String exibirPainel(Model model) {
        // Busca a lista no banco
        List<FoodDTO> lista = foodItemService.listar();
        model.addAttribute("alimentos", lista); // Variável usada na tabela do HTML

        // Cria o objeto vazio para o formulário de "Adicionar"
        model.addAttribute("save", new FoodDTO());

        // Define a aba inicial
        model.addAttribute("abaAtiva", "geladeira");

        // Retorna o NOME EXATO do seu arquivo HTML (sem .html)
        return "Painel_geladeira";
    }

    // 2. Ação de Criar (Vinda do formulário HTML)
    // O HTML usa method="post" em th:action="@{/food/ui/criar}"
    @PostMapping("/criar")
    public String criarViaFormulario(@ModelAttribute("save") FoodDTO foodDTO) {
        foodItemService.salvar(foodDTO);
        // Após salvar, recarrega a página do painel para mostrar o novo item
        return "redirect:/food/ui/painel";
    }

    // 3. Ação de Deletar (Vinda do botão HTML)
    // O HTML usa method="post" em th:action="@{/food/ui/deletar/{id}}"
    @PostMapping("/deletar/{id}")
    public String deletarViaFormulario(@PathVariable Long id) {
        foodItemService.deletar(id);
        // Após deletar, recarrega a página
        return "redirect:/food/ui/painel";
    }

    // 4. Ação de Gerar Receita (Aba de Receitas)
    @GetMapping("/gerar-receita")
    public String gerarReceita(Model model) {
        // Lógica simulada
        String receita = "<h3>Sugestão do Dia</h3><p>Com base nos seus itens: Omelete de Forno.</p>";

        // Precisamos recarregar os dados do painel pois estamos retornando para a mesma view
        model.addAttribute("alimentos", foodItemService.listar());
        model.addAttribute("save", new FoodDTO());

        model.addAttribute("receitaGerada", receita);
        model.addAttribute("abaAtiva", "receitas"); // Mantém a aba de receitas aberta

        return "Painel_geladeira";
    }

    // =================================================================================
    //  PARTE 2: MÉTODOS REST / API (JSON)
    //  OBS: Renomeei as rotas adicionando "_api" para não dar conflito com a UI acima.
    // =================================================================================

    @PostMapping("/api/criar")
    public ResponseEntity<FoodDTO> criarApi(@RequestBody FoodDTO foodDTO) {
        FoodDTO save = foodItemService.salvar(foodDTO);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/api/listar")
    public ResponseEntity<List<FoodDTO>> listarApi(){
        List<FoodDTO> listarComidas = foodItemService.listar();
        return ResponseEntity.ok(listarComidas);
    }

    @GetMapping("/api/listarId/{id}")
    public ResponseEntity<FoodDTO> listarPorIdApi(@PathVariable Long id) {
        FoodDTO foodDTO = foodItemService.listarPorId(id);
        if (foodDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(foodDTO);
    }

    @DeleteMapping("/api/deletar/{id}")
    public ResponseEntity<Void> deletarItemApi (@PathVariable Long id){
        foodItemService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/atualizar/{id}")
    public ResponseEntity<FoodDTO> atualizarItemApi(@PathVariable Long id, @RequestBody FoodDTO atualizacao){
        FoodDTO atualizado = foodItemService.atualizar(id, atualizacao);
        return ResponseEntity.ok(atualizado);
    }
}