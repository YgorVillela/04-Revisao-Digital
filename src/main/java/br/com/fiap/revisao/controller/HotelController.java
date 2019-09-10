package br.com.fiap.revisao.controller;

import br.com.fiap.revisao.model.Hotel;
import br.com.fiap.revisao.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelRepository rep;

    @GetMapping("/cadastrar")
    public String cadastrar(Hotel hotel){
        return "hotel/cadastrar";
    }

    //Cadastro
    @PostMapping("/cadastrar")
    public String cadastrar(Hotel hotel, RedirectAttributes redirectAttributes){
        rep.save(hotel);
        redirectAttributes.addFlashAttribute("msg","Cadastrado!");
        return "redirect:/hotel/listar";
    }

    //Atualizar
    @PostMapping("/atualizar")
    public String atualizar(Hotel hotel, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg", "Atualizado!");
        rep.save(hotel);
        return "redirect:/hotel/listar";
    }
    //atualizar com get
    @GetMapping("/atualizar/{id}")
    public String editar(@PathVariable("id") int codigo , Model model){
        model.addAttribute("hotel", rep.findById(codigo));
        return "/hotel/atualizar"; // aqui deve ser o mesmo nome da pagina html
    }


    //Listar
    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("lista", rep.findAll()); // isso é o que lista
        model.addAttribute("msg", "Listado!");
        return "hotel/listar";
    }

    @PostMapping("/deletar")
    public String apagar(int codigo, RedirectAttributes redirectAttributes){
        rep.deleteById(codigo);
        redirectAttributes.addFlashAttribute("msg", "Apagado!");
        return "redirect:/hotel/listar";
    }

    //@GetMapping("busca")

}
