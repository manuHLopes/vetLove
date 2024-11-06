package model;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Animal {
    private static int contadorAnimal = 0;
    private int id_animal;
    private String raca;
    private String nome_animal;
    private String especie;
    private String data_nascimento_animal;
    private String pelagem;
    private char sexo;
    private int id_cliente; // como se fosse a chave estrangeira
    // double peso_animal; acho que isso aqui fica melhor no prontuário

    public Animal(){
        id_animal = ++contadorAnimal;
        this.nome_animal = "";
        this.especie = "";
        this.raca = "";
        this.pelagem= "";
        this.sexo = '0';
        this.data_nascimento_animal = "";
    }

    public Animal(int id_cliente){
        id_animal = ++contadorAnimal;
        this.id_cliente = id_cliente;
        this.nome_animal = "";
        this.especie = "";
        this.raca = "";
        this.pelagem= "";
        this.sexo = '0';
        this.data_nascimento_animal = "";
    }

    public Animal(String nome_animal, String especie, String raca, String pelagem, char sexo, String data_nascimento_animal){
        id_animal = ++contadorAnimal;
        this.nome_animal = nome_animal;
        this.especie = especie;
        this.raca = raca;
        this.pelagem= pelagem;
        this.sexo = sexo;
        this.data_nascimento_animal = data_nascimento_animal;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNome_animal() {
        return nome_animal;
    }

    public void setNome_animal(String nome_animal) {
        this.nome_animal = nome_animal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getData_nascimento_animal() {
        return data_nascimento_animal;
    }

    public void setData_nascimento_animal(String data_nascimento_animal) {
        this.data_nascimento_animal = data_nascimento_animal;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    // metodos
    public String exibir(){
        return "\nnome: " + nome_animal + "\nespecie: " +
                especie + "\nraça: " + raca + "\npelagem: "+
                pelagem+ "\nsexo: " +sexo+ "\nnascimento: " +data_nascimento_animal;
    }

}
