package view;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Scanner ler2 = new Scanner(System.in);

        // primeiramente estabelecemos nossas duas funções de acesso
        ArrayList<Funcao> lista_funcoes = new ArrayList<Funcao>();
        lista_funcoes.add(new Funcao("Médico")); // indice 0
        lista_funcoes.add(new Funcao("Recepcionista")); // indice 1
        boolean autenticado = false;
        Usuario user_atual = new Usuario();

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Atendimento> lista_atendimentos = new ArrayList<>();
        ArrayList<TipoServico> lista_tiposervicos = new ArrayList<>();
        ArrayList<Medico> lista_medicos = new ArrayList<>();

        while(true) {
            // AUTENTICAÇÃO DO USUÁRIO
            do {
                int op;
                autenticado = false;

                System.out.println("\n======== VET LOVE =======\n");

                int funcao;

                System.out.println("\n1 - entrar\n2 - cadastrar novo usuario");
                op = ler.nextInt();

                switch (op) {
                    case 1:
                        do {
                            System.out.println("\n===== entrar =====\n1 - " + lista_funcoes.get(0).getDescricao_funcao() + "\n2 - " + lista_funcoes.get(1).getDescricao_funcao());
                            funcao = ler.nextInt();
                        } while (funcao != 1 && funcao != 2);

                        if (lista_funcoes.get(funcao - 1).usuarios.isEmpty()) {
                            System.out.println("ainda não há usuários cadastrados");
                        } else {
                            System.out.println("login:");
                            String login = ler2.nextLine();
                            System.out.println("senha:");
                            String senha = ler2.nextLine();

                            for (Usuario usuario : lista_funcoes.get(funcao - 1).usuarios) {
                                if (login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())) {
                                    autenticado = true;
                                    user_atual = usuario;
                                }
                            }
                            if (!autenticado) System.out.println("credenciais inválidas, tente novamente.");
                        }
                        break;
                    case 2:
                        do {
                            System.out.println("\n===== cadastrar =====\n1 - " + lista_funcoes.get(0).getDescricao_funcao() + "\n2 - " + lista_funcoes.get(1).getDescricao_funcao());
                            funcao = ler.nextInt();
                        } while (funcao != 1 && funcao != 2);

                        lista_funcoes.get(funcao - 1).adicionar_usuario();
                        break;
                    default:
                        System.out.println("insira uma opção válida!");
                }
            } while (!autenticado);


            // MENU DO USUÁRIO

            int menu;
            do {
                System.out.println("\n===== DASHBOARD =====\n");
                System.out.println("Bem vindo, " + user_atual.getNome_usuario() + "!");
                System.out.println("Escolha uma opção:\n0 - Logout\n1 - Cadastrar novo cliente\n2 - Adicionar pet a um cliente existente\n3 - Cadastrar um atendimento\n4 - Cadastrar serviços\n5 - Atender Consulta");
                menu = ler.nextInt();
                char continuar;
                int id_cliente;
                int index_animal;
                boolean completou_cadastro = false;

                switch (menu) {
                    case 0:
                        System.out.println("====== Tchauzinho, até mais!! ");
                        break;
                    case 1:
                        clientes.add(new Cliente().cadastrar_cliente());
                        do {
                            clientes.getLast().adicionar_animal();
                            System.out.println("\n === deseja cadastrar outro pet? (s/n)");
                            continuar = ler.next().charAt(0);
                        } while (continuar == 's' || continuar == 'S');
                        break;
                    case 2:
                        System.out.println("=== clientes ===");
                        if (clientes.isEmpty()) {
                            System.out.println("ainda não há clientes cadastrados");
                        } else {
                            for (Cliente cliente : clientes) {
                                cliente.exibir_cliente();
                            }
                            System.out.println("selecione a id do cliente que deseja adicionar o pet: ");
                            id_cliente = ler.nextInt();
                            do {
                                clientes.get(id_cliente).adicionar_animal();
                                System.out.println("\n === deseja cadastrar outro pet? (s/n)");
                                continuar = ler.next().charAt(0);
                            } while (continuar == 's' || continuar == 'S');
                        }
                        break;
                    case 3:
                        int op_atend;
                        int indice_servico;
                        double valor_total = 0;
                        System.out.println("\n==== atendimento ====\n");

                        System.out.println("=== clientes === ");
                        if (clientes.isEmpty()) {
                            System.out.println("ainda não há clientes cadastrados");
                        } else {
                            for (Cliente cliente : clientes) {
                                cliente.exibir_cliente();
                            }
                            System.out.println("selecione a id do cliente desejado: ");
                            id_cliente = ler.nextInt();
                            clientes.get(id_cliente - 1).exibe_pets();
                            System.out.println("selecione o numero do pet desejado:");
                            index_animal = ler.nextInt() - 1;

                            do {
                                System.out.println("\n1 - consulta\n2 - serviços");
                                op_atend = ler.nextInt();

                                switch (op_atend) {
                                    case 1:
                                        //adicionando na lista de atendimentos
                                        lista_atendimentos.add(user_atual.adicionar_consulta(clientes.get(id_cliente - 1).getAnimais().get(index_animal).getId_animal()));

                                        lista_atendimentos.getLast().adicionar_pagamentos();
                                        break;
                                    case 2:
                                        if(!lista_tiposervicos.isEmpty()) {
                                            int i = 0;
                                            for (TipoServico tipo : lista_tiposervicos) {
                                                System.out.println("Indice nº: " + i + "\n" + tipo.imprimir());
                                                i++;
                                            }
                                            System.out.println("Escolha um indice de serviço: ");
                                            indice_servico = ler.nextInt();

                                            //adicionando na lista de atendimentos
                                            lista_atendimentos.add(user_atual.adicionar_servico(lista_tiposervicos.get(indice_servico), clientes.get(id_cliente - 1).getAnimais().get(index_animal).getId_animal()));
                                            lista_atendimentos.getLast().adicionar_pagamentos();
                                        } else System.out.println("ainda não há serviços cadastrados!");
                                        break;
                                }
                                System.out.println("deseja realizar uma nova consulta ou serviço? s/n");
                                continuar = ler.next().charAt(0);
                            } while (continuar == 's' || continuar == 'S');
                        }
                        break;
                    case 4:
                        do {
                            lista_tiposervicos.add(new TipoServico().cadastrarTipoDeServico());
                            System.out.println("deseja cadastrar um novo tipo de serviço? s/n");
                            continuar = ler.next().charAt(0);
                        } while (continuar == 's' || continuar == 'S');
                        break;
                    default:
                        System.out.println("insira uma opção válida!");
                        break;
                    case 5:
                        if(user_atual.getId_funcao() == lista_funcoes.getFirst().getId_funcao()){

                            System.out.println("===== \nFuncionalidade em construção! :D\nTente novamente no terceiro ciclo <3");

                        } else System.out.println("Desculpe, essa área só pode ser acessada por Médicos Veterinários.");
                        break;
                }

            } while (menu != 0);
        }
    }
}
