package com.example.demo.controller;

import com.example.demo.dto.ContatoDTO;
import com.example.demo.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("contatoDTO", new ContatoDTO());
        return "index";
    }

    @PostMapping("/enviar")
    public String enviarContato(@Valid ContatoDTO contatoDTO, BindingResult result, Model model) {

        // Se houver erro de validação (ex: e-mail inválido), volta pra página com erros
        if (result.hasErrors()) {
            return "index";
        }

        try {
            emailService.enviarOrcamento(contatoDTO.getNome(), contatoDTO.getTelefone(), contatoDTO.getMensagem());
            model.addAttribute("sucesso", "Mensagem enviada! Entraremos em contato.");
            model.addAttribute("contatoDTO", new ContatoDTO()); // Limpa o form
        } catch (Exception e) {
            model.addAttribute("erro", "Erro ao enviar. Tente pelo WhatsApp.");
        }

        return "index";
    }
}
