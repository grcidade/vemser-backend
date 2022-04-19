package com.dbc.vemser.pessoa_api.service;

import com.dbc.vemser.pessoa_api.dto.AtributosEmailDTO;
import com.dbc.vemser.pessoa_api.dto.EnderecoDTO;
import com.dbc.vemser.pessoa_api.dto.PessoaDTO;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    private static final String MAIL_TO = "guilherme.cidade@dbccompany.com.br";

//    @Value("${spring.mail.username}")
//    private String from;
    private final JavaMailSender emailSender;

    public void sendSimpleMessageKafka(AtributosEmailDTO atributosEmailDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MAIL_TO);
        message.setTo(atributosEmailDTO.getDestinatario());
        message.setSubject(atributosEmailDTO.getAssunto());
        message.setText(atributosEmailDTO.getTexto());
        emailSender.send(message);
    }

//    public void sendSimpleMessage(PessoaDTO pessoaQueVaiReceberEmail) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(MAIL_TO);
//        message.setTo(MAIL_TO);
//        message.setSubject("Atualize seu EMAIL");
//        message.setText("Ola " + pessoaQueVaiReceberEmail.getNome() + "!\n\n" +
//                "Estamos muito felizes que você está em nosso sitema.\n" +
//                "Para que possamos enviá-los um brinde exclusivo, por gentileza, adicione ou atualize o seu endereço no seu cadastro" + "\n\n" +
//                "Muito Obrigado,\n" +
//                "Sistema de Pessoas.");
//        emailSender.send(message);
//    }
//
//    public void sendSimpleMessageDois(PessoaDTO pessoaQueVaiReceberEmail) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(MAIL_TO);
//        message.setTo(MAIL_TO);
//        message.setSubject("Feliz Aniversário");
//        message.setText("Ola " + pessoaQueVaiReceberEmail.getNome() + "!\n\n" +
//                "Selecionamos alguns dos nossos melhores produtos e criamos esta super promoção na nossa plataforma especialmente para você:\n" +
//                "- Na compra de um CDs do Chitãozinho e Xororó, ganhe 1 do Milionário e José Rico." + "\n" +
//                "- Na locação de um filme em VHS, a outra locação é grátis." + "\n" +
//                "- Fita de Super Nintendo com 50% de desconto." + "\n\n" +
//                "Aproveite,\n" +
//                "Magazine OldSchool.");
//        emailSender.send(message);
//    }
//
//    public void sendSimpleMessageBirthday(PessoaDTO pessoaQueVaiReceberEmail, Integer idade) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(MAIL_TO);
//        message.setTo(MAIL_TO);
//        message.setSubject("Ofertas");
//        message.setText("Ola " + pessoaQueVaiReceberEmail.getNome() + "!\n\n" +
//                "Essa data de " + pessoaQueVaiReceberEmail.getDataNascimento().getDayOfMonth() + "/" + pessoaQueVaiReceberEmail.getDataNascimento().getMonth().getValue() + " também é especial para nós do " +
//                "Vem Ser. Estamos comemorando com você." + "\n\n" +
//                "Desejamos um feliz aniversário, que tenham sido " + idade + " anos de muito sucesso, alegria, felicidade e muitas realizações." + "\n\n" +
//                "Forte Abraço,\n" +
//                "#VemSerDBC!");
//        emailSender.send(message);

//    }

//    public void sendWithAttachment(PessoaDTO pessoaQueVaiReceberEmail) throws MessagingException {
//        MimeMessage message = emailSender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(message,
//                true);
//
//        helper.setFrom(from);
//        helper.setTo(pessoaQueVaiReceberEmail.getEmail());
//        helper.setSubject("RECEBA LUVA DE PEDREIRO MELHOR DO MUNDO GRAÇAS A DEUS");
//        helper.setText("Ola " + pessoaQueVaiReceberEmail.getNome() + "!\n" +
//                "Estamos felizes em ter você em nosso sistema :)\n" +
//                "Seu cadastro foi realizado com sucesso, seu indentificador é " + pessoaQueVaiReceberEmail.getIdPessoa() + "\n\n" +
//                "Qualquer dúvida é entrar em contato com o suporte pelo e-mail " + from + ".\n\n" +
//                "Att,\n" +
//                "Sistema.");
//
//        File file1 = new File("src/main/resources/imagem.jpg");
//
//        FileSystemResource file
//                = new FileSystemResource(file1);
//        helper.addAttachment(file1.getName(), file);
//
//        emailSender.send(message);
//    }
//
//    public void sendEmail(PessoaDTO pessoaQueVaiReceberEmail, String tipo) {
//        MimeMessage mimeMessage = emailSender.createMimeMessage();
//        try {
//
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//
//            mimeMessageHelper.setFrom(from);
//            mimeMessageHelper.setTo(pessoaQueVaiReceberEmail.getEmail());
//            mimeMessageHelper.setSubject("RECEBA LUVA DE PEDREIRO MELHOR DO MUNDO GRAÇAS A DEUS");
//            mimeMessageHelper.setText(geContentFromTemplate(pessoaQueVaiReceberEmail, tipo), true);
//
//            emailSender.send(mimeMessageHelper.getMimeMessage());
//        } catch (MessagingException | IOException | TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String geContentFromTemplate(PessoaDTO pessoa, String tipo) throws IOException, TemplateException {
//        Map<String, Object> dados = new HashMap<>();
//        dados.put("nome", pessoa.getNome());
//        dados.put("id", pessoa.getIdPessoa());
//        dados.put("email", MAIL_TO);
//        fmConfiguration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
//        Template template;
//        if(tipo.equalsIgnoreCase("create")){
//            template = fmConfiguration.getTemplate("email-template-create.ftl");
//        } else if(tipo.equalsIgnoreCase("update")){
//            template = fmConfiguration.getTemplate("email-template-update.ftl");
//        } else{
//            template = fmConfiguration.getTemplate("email-template-delete.ftl");
//        }
//        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
//        return html;
//    }
//
//    public void sendEmailWithAddress(PessoaDTO pessoaQueVaiReceberEmail, EnderecoDTO enderecoDTO, String tipo) {
//        MimeMessage mimeMessage = emailSender.createMimeMessage();
//        try {
//
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//
//            mimeMessageHelper.setFrom(from);
//            mimeMessageHelper.setTo(pessoaQueVaiReceberEmail.getEmail());
//            mimeMessageHelper.setSubject("TESTE ENDERECO");
//            mimeMessageHelper.setText(geContentFromTemplateWithAddress(pessoaQueVaiReceberEmail,enderecoDTO,tipo), true);
//
//            emailSender.send(mimeMessageHelper.getMimeMessage());
//        } catch (MessagingException | IOException | TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String geContentFromTemplateWithAddress(PessoaDTO pessoa, EnderecoDTO enderecoDTO, String tipo) throws IOException, TemplateException {
//        Map<String, Object> dados = new HashMap<>();
//        dados.put("nome", pessoa.getNome());
//        dados.put("id", pessoa.getIdPessoa());
//        dados.put("idEndereco", enderecoDTO.getIdEndereco());
//        dados.put("email", MAIL_TO);
//        fmConfiguration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
//        Template template;
//        if(tipo.equalsIgnoreCase("create")){
//            template = fmConfiguration.getTemplate("email-template-address-create.ftl");
//        } else if(tipo.equalsIgnoreCase("update")){
//            template = fmConfiguration.getTemplate("email-template-address-update.ftl");
//        } else{
//            template = fmConfiguration.getTemplate("email-template-address-delete.ftl");
//        }
//        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
//        return html;
//    }
}
