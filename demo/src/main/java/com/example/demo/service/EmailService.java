package com.example.demo.service;// Pacote: service


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarOrcamento(String nome, String contato, String texto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(""); // E-mail da empresa que receberá
        message.setSubject("Novo Lead: " + nome);
        message.setText("Cliente: " + nome + "\nContato: " + contato + "\n\nMensagem:\n" + texto);

        mailSender.send(message);
    }
}