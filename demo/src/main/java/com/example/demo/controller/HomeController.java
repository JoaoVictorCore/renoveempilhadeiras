package com.example.demo.controller;

import com.example.demo.dto.ContatoDTO;
import com.example.demo.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        // Apenas adicione o DTO necessário para o formulário
        model.addAttribute("contatoDTO", new ContatoDTO());
        // NÃO adicione 'sucesso' ou 'erro' aqui
        return "index";
    }

    @PostMapping("/enviar")
    public String enviarContato(@Valid @ModelAttribute("contatoDTO") ContatoDTO contatoDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Em caso de erro de validação, mantém os erros e o formulário
            model.addAttribute("erro", "Por favor, corrija os erros no formulário.");
            return "index";
        }

        // Simulação de envio bem-sucedido
        // Lógica para enviar e-mail ou salvar no banco...

        // Adiciona a mensagem de sucesso
        model.addAttribute("sucesso", "Mensagem enviada com sucesso! Em breve entraremos em contato.");

        // Limpa o DTO para um novo envio
        model.addAttribute("contatoDTO", new ContatoDTO());

        return "index";
    }
}
