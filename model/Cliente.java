package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private static int contadorClientes = 0;
    private int id_cliente;
    private String data_nascimento_cliente;
    private String telefone;
    private String endereco;
    private String cpf;
    private String email;
    private String nome_cliente;
    private ArrayList<Animal> animais;

    public Cliente(String nome_cliente, String cpf, String data_nascimento_cliente, String telefone, String endereco, String email, ArrayList<Animal> animais) {
        this.id_cliente = ++contadorClientes;
        this.data_nascimento_cliente = data_nascimento_cliente;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.email = email;
        this.nome_cliente = nome_cliente;
        this.animais = new ArrayList<Animal>();
    }

    public Cliente() {
        this.id_cliente = ++contadorClientes;
        this.data_nascimento_cliente = "";
        this.telefone = "";
        this.endereco = "";
        this.cpf = "";
        this.email = "";
        this.nome_cliente = "";
        this.animais = new ArrayList<Animal>();
    }

    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(ArrayList<Animal> animais) {
        this.animais = animais;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getData_nascimento_cliente() {
        return data_nascimento_cliente;
    }

    public void setData_nascimento_cliente(String data_nascimento_cliente) {
        this.data_nascimento_cliente = data_nascimento_cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    //metodos

    public Cliente cadastrar_cliente(){
        Scanner ler = new Scanner(System.in);

        System.out.println("Insira o nome do cliente: ");
        this.setNome_cliente(ler.nextLine());

        System.out.println("Insira o cpf: ");
        this.setCpf(ler.nextLine());

        System.out.println("Insira a data de nascimento: ");
        this.setData_nascimento_cliente(ler.nextLine());

        System.out.println("Insira o telefone: ");
        this.setTelefone(ler.nextLine());

        System.out.println("Insira o email: ");
        this.setEmail(ler.nextLine());

        System.out.println("Insira o endereço: ");
        this.setEndereco(ler.nextLine());

        return this;
    }

    public void exibir_cliente(){
        System.out.println("\n==============");
        System.out.println(this.exibir());
        System.out.println("\n==============");
    }

    public String exibir(){
        return "\nid: " + id_cliente + "\nnome: " + nome_cliente + "\ncpf: " + cpf +
                "\ntelefone: " + telefone + "\nnascimento: " + data_nascimento_cliente +
                "\nemail: " + email + "\nendereço: " + endereco;
    }

    public void adicionar_animal(){
        Scanner ler = new Scanner(System.in);
        Scanner lerchar = new Scanner(System.in);
        Animal animal = new Animal();

        System.out.println("\n========= cadastrar pet =========");

        System.out.println("Insira o nome do pet: ");
        animal.setNome_animal(ler.nextLine());

        System.out.println("Insira a espécie do pet: ");
        animal.setEspecie(ler.nextLine());

        System.out.println("Insira a raça do pet: ");
        animal.setRaca(ler.nextLine());

        System.out.println("Insira a pelagem do pet: ");
        animal.setPelagem(ler.nextLine());

        System.out.println("Insira o sexo do pet: ");
        animal.setSexo(lerchar.next().charAt(0));

        System.out.println("Insira a data de nascimento: ");
        animal.setData_nascimento_animal(ler.nextLine());

        animais.add(animal);
    }

    public void exibe_pets(){
        int i = 1;
        System.out.println("\n======== lista de pets ========");
        for(Animal animal : animais) {
            System.out.println("\n Pet nº " + i);
            System.out.println(animal.exibir());
            i++;
        }
    }

    public void remover_animal(){
        Scanner ler = new Scanner(System.in);
        int indice;
        System.out.println("\n====== remover pet =======");
        System.out.println("Qual animal pet você deseja remover?");
        indice = ler.nextInt();
        animais.remove(indice-1);
    }

    public boolean tem_pets(){
        return !animais.isEmpty();
    }
}
