/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.produtos.produtos.controllers;

import br.com.produtos.produtos.models.ProdRepository;
import br.com.produtos.produtos.models.ProdutosModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Aluno
 *
 * classe responsável por controlar ações recebendo requisições e enviando
 * respostas para a visão
 */
@Controller
public class ProdutosController {

    //usa injeção de dependência para criar um repositório de tarefas
    @Autowired
    ProdRepository repo;

    /*
recebe requisições do tipo GET nas urls "/" e "/index"
adiciona a lista de tarefas (ordenadas por descrição) na resposta
e envia para a página tarefas.jsp
     */
    @GetMapping({"/", "/index"})
    public String lista(Model model) {
        
            /*busca no banco as tarefas ordenando por descrição*/
        List produtos = repo.findAll(Sort.by("nomeProduto"));
        /*adiciona a lista na resposta*/
        model.addAttribute("produtos", produtos);
        /*envia para a página tarefas.jsp*/
        return "home";
    }

    /*
trata uma requisição do tipo GET na url "/cadastro"
enviando para a página cadastro.jsp
     */
    @GetMapping({"/cadastro"})
    public String abreCadastro() {
        return "cadastro";
    }

    /*
trata uma requisição do tipo POST na url "/cadastro"
inserindo no banco de dados a tarefa passada pelo cliente (FORM)
depois retorna a listagem (ao chamar o método lista(model))
     */
    @PostMapping({"/cadastro"})
    public String adiciona(Model model, ProdutosModel prod) {
        repo.save(prod);

        return "redirect:/";
//        return lista(model);
    }

    @GetMapping("/exclui")
    public String exclui(Model model, Long id) {
        repo.deleteById(id);
        return "redirect:/";
//        return lista(model);;
    }

    @GetMapping("/editar")
    public String edita(Model model, Long id) {

        ProdutosModel produto = repo.findById(id).get();
        model.addAttribute("produto", produto);
        return "editar";
    }

    @GetMapping("/ver")
    public String verProduto(Model model, Long id) {
        ProdutosModel produto = repo.findById(id).get();
        model.addAttribute("produto", produto);
        return "produto";
    }
    
    @GetMapping("/search")
     public String consultarProduto() {
         return "redirect:/";
     }

    @PostMapping("/search")
    public String consultarProduto(Model model, String pesquisa) {

        if(pesquisa.equals("")){
            return "redirect:/";
        }
        
        boolean isNumeric =  pesquisa.matches("[+-]?\\d*(\\.\\d+)?");
        if(isNumeric){
            
            Long i = Long.parseLong(pesquisa);
            ProdutosModel produto = repo.findById(i).get();
            model.addAttribute("produto", produto);
            
            System.out.println(model);
            return "home_1";
        }else{
            return "redirect:/";
        }

//        isNumeric =  id.matches("[+-]?\\d*(\\.\\d+)?");;
//        System.out.println(isNumeric);
//
//        isNumeric =  id.matches("[+-]?\\d*(\\.\\d+)?");
//        System.out.println(isNumeric);

    }

}
