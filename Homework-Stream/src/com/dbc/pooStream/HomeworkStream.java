package com.dbc.pooStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeworkStream {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

        //1- listar todas as pessoas
        System.out.println();
        System.out.println("Lista completa: ");
        lista.forEach(System.out::println);

        //2- filtrar todas as pessoas com salario maior do que 5 mil
        List<Pessoa> listSalarioMaiorQue5Mil = lista.stream()
                .filter(pessoa -> pessoa.getSalario() > 5000)
                .collect(Collectors.toList());
        System.out.println();
        System.out.println("Lista com Salario > 5000");
        listSalarioMaiorQue5Mil.forEach(System.out::println);

        //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente
        List<Pessoa> listDesenvolvedoresSalarioCrescente = lista.stream()
                .filter(pessoa -> pessoa.getCargo().contains("Desenvolvedor"))
                .sorted(Comparator.comparing(Pessoa::getSalario))
                .collect(Collectors.toList());
        System.out.println();
        System.out.println("Lista com Desenvolvedores e Salario Crescente");
        listDesenvolvedoresSalarioCrescente.forEach(System.out::println);

        //4- fazer a média salarial de todos
        double mediaSalarial = lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average()
                .getAsDouble();
        System.out.println();
        System.out.println("Media Salarial: ");
        System.out.printf("%.2f%n", mediaSalarial);

        //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil

        boolean salarioMaiordeVinteMil = lista.stream()
                .anyMatch(pessoa -> pessoa.getSalario() > 20000);
        System.out.println();
        System.out.println("Tem alguem com salario maior que 20 mil: ");
        System.out.println(salarioMaiordeVinteMil);

        //6 - retornar uma lista de todos os ids das pessoas

        List<Integer> listDeIds = lista.stream()
                .map(Pessoa::getId)
                .collect(Collectors.toList());
        System.out.println();
        System.out.println("Lista de Ids");
        listDeIds.forEach(System.out::println);

        //7 - criar uma classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto

        List<Salario> listSalario = lista.stream()
                .map(pessoa -> new Salario(pessoa.getId(), pessoa.getSalario()))
                .collect(Collectors.toList());
        System.out.println();
        System.out.println("Lista da Classe Salario");
        listSalario.forEach(System.out::println);

        //8- retornar um Map (HashMap) contendo os ids e os nomes dos colaboradores

        Map<Integer, String> idsENomes = lista.stream()
                .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
        System.out.println();
        System.out.println("Lista de Ids e Nomes");
        System.out.println(idsENomes);

        //9- com o mapa da questão 8, retornar o nome com o id=2

        List<String> nomeComIdDois = idsENomes.entrySet().stream()
                .filter(x -> x.getKey() == 2)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        System.out.println();
        System.out.println("Nome no Id 2: ");
        System.out.println(nomeComIdDois);

    }

    static class Pessoa {
        private int id;
        private String nome;
        private double salario;
        private String cargo;

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "Pessoa{" + "id=" + id + ", nome='" + nome + '\'' + ", salario=" + salario + ", cargo='" + cargo + '\'' + '}';
        }
    }

    static class Salario{
        private int id;
        private double salario;

        public Salario(int id, double salario) {
            this.id = id;
            this.salario = salario;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        @Override
        public String toString() {
            return "Salario{" + "id=" + id + ", salario=" + salario + '}';
        }
    }
}
