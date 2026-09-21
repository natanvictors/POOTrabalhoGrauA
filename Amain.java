public class Amain {
    public static void main(String[] args) {

        ContaBancaria contaAberta = null;

        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n========== MENU BANCÁRIO ==========");
            if(contaAberta == null) {
                System.out.println("1 - Criar Conta");
            } else {
            System.out.println("2 - Depósito");
            System.out.println("3 - Saque");
            System.out.println("4 - Aplicar Juros");
            System.out.println("5 - Extrato");
            System.out.println("6 - Integrantes");
            } 
            System.out.println("7 - Sair");
            System.out.println("===================================");

            opcao = Teclado.leInt("Escolha uma opção do menu: ");

            if (opcao == 1) {
                if (contaAberta == null) {
                    String nome = Teclado.leString("Digite o seu nome:");
                    if (nome != null && !nome.trim().isEmpty()) {
                        String[] partes = nome.trim().split("\\s+");
                        StringBuilder nomeFormatado = new StringBuilder();
                        for (String parte : partes) {
                            if (parte.length() > 0) {
                                nomeFormatado.append(parte.substring(0, 1).toUpperCase())
                                        .append(parte.substring(1).toLowerCase()).append(" ");
                            }
                        }
                        nome = nomeFormatado.toString().trim();
                    }
                    String cpf = Teclado.leString("Digite o seu CPF: ");
                    while (cpf.length() != 11) { // Segue perguntando caso o CPF não tenha, ao menos, 11 dígitos
                        System.out.println("CPF INVÁLIDO! O CPF precisa de 11 dígitos");
                        cpf = Teclado.leString("Digite o seu CPF: ");
                    }
                    int dia = Teclado.leInt("Digite o dia do seu nascimento: ");
                    while (dia < 1 || dia > 31) {
                        System.out.println("ERRO! Digite um valor válido para um dia (1 a 31)");
                        dia = Teclado.leInt("Digite o dia do seu nascimento: ");
                    }
                    int mes = Teclado.leInt("Digite o mes do seu nascimento");
                    while (mes < 1 || mes > 12) {
                        System.out.println("ERRO! Digite um valor válido para o mês (1 a 12)");
                        mes = Teclado.leInt("Digite o mes do seu nascimento");
                    }
                    int ano = Teclado.leInt("Digite o ano do seu nascimento: ");
                    while (ano < 1900 || ano > 2026) {
                        System.out.println("ERRO! Digite um valor válido para o ano (1900 a 2026)");
                        ano = Teclado.leInt("Digite o ano do seu nascimento: ");
                    }
                    Data D1 = new Data(dia, mes, ano); // Objeto que reúne a data de nascimento do cliente
                    Cliente A1 = new Cliente(nome, cpf, D1); // Objeto que efetivamente recebe todos os dados do cliente
                    Double saldoIncial = Teclado.leDouble("Qual o saldo inicial da sua conta?");
                    char tipoConta = Teclado.leChar(
                            "Selecione o tipo de conta que queres abrir\nUse 'C' para conta corrente.\nUse 'P' para conta poupança.\nUse 'I' para conta de investimento");
                    tipoConta = Character.toUpperCase(tipoConta);

                    if (tipoConta == 'C') {
                        Double limiteCredito = Teclado.leDouble("Qual o limite de crédito quer para sua conta?");
                        contaAberta = new ContaCorrente(saldoIncial, limiteCredito);// Cria a conta corrente
                        contaAberta.setCliente(A1); // Informa os dados do cliente
                    } else if (tipoConta == 'P') {
                        int diaAniversario = Teclado.leInt("Qual o dia do 'aniversário' da sua conta?");
                        contaAberta = new ContaPoupanca(saldoIncial, diaAniversario); // Cria a conta poupança
                        contaAberta.setCliente(A1); // Informa os dados do cliente

                    } else if (tipoConta == 'I') {
                        int vencDia = Teclado.leInt("Digite o dia do vencimento do seu investimento: ");
                        while (vencDia < 1 || vencDia > 31) {
                            System.out.println("ERRO! Digite um valor válido para um dia (1 a 31)");
                            vencDia = Teclado.leInt("Digite o dia do seu nascimento: ");
                        }
                        int vencMes = Teclado.leInt("Digite o mês do vencimento do seu investimento: ");
                        while (vencMes < 1 || vencMes > 12) {
                            System.out.println("ERRO! Digite um valor válido para o mês (1 a 12)");
                            vencMes = Teclado.leInt("Digite o mes do seu nascimento");
                        }
                        int vencAno = Teclado.leInt("Digite o ano do vencimento do seu investimento: ");
                        while (vencAno < 2026) {
                            System.out.println("Ano inválido! Investimentos com vencimentos somente a partir de 2026");
                            vencAno = Teclado.leInt("Digite o ano do vencimento do seu investimento: ");
                        }
                        Data V1 = new Data(vencDia, vencMes, vencAno); // Cria o objeto data com os dados reúnidos
                        contaAberta = new ContaInvestimento(saldoIncial, V1); // Cria a conta de investimento
                        contaAberta.setCliente(A1); // Informa os dados do cliente

                    } else {
                        System.out.println("ERRO! Tipo de conta inválido. Tente abrir a conta novamente.");
                    }
                } else
                    System.out.print("ERRO! Você já possui uma conta aberta");

            }

            else if (opcao == 2) {
                if (contaAberta != null) {
                    System.out.println("--- VOCÊ ENTROU NA OPÇÃO DE DEPÓSITO ---");
                    Double valorDeposito = Teclado.leDouble("Digite o valor do seu depósito");
                    if (valorDeposito <= 0) {
                        System.out.println("ERRO! Você só pode depositar valores maiores que zero");
                    } else {
                        Operacao operacaoDeposito = new Operacao('D', valorDeposito);
                        contaAberta.movimenta(operacaoDeposito);// Usando o metodo movimenta para passar os dados da
                                                                // operação depósito
                        System.out.println("Depósito realizado! Novo saldo: R$ " + contaAberta.getSaldoAtual());
                    }
                } else {
                    System.out.println("ERRO! Abra uma conta primeiro antes de tentar realizar um depósito!");
                }
            }

            else if (opcao == 3) {
                if (contaAberta != null) {
                    if (contaAberta instanceof ContaCorrente || contaAberta instanceof ContaPoupanca) {
                        
                        System.out.println("--- VOCÊ ENTROU NA OPÇÃO DE SAQUE ---");
                        double valorSaque = Teclado.leDouble("Digite o valor do saque:R$ ");
                        if (valorSaque > 0 && valorSaque == (int) valorSaque) { // Verifica se o valor é maior que zero
                                                                                // e se é o mesmo valor no formato
                                                                                // inteiro, ou seja, sem centavos.
                            if (contaAberta.podeSacar(valorSaque)) { // Verifica se a conta possui saldo ou limite suficiente 
                                                                     // para realizar o saque.
                                                                     // Lógica para contagem de notas
                                int[] quantidade = new int[6];

                                boolean saquePossivel = contaAberta.verificaCedulas(
                                        (int) valorSaque,
                                        0,
                                        quantidade);
                                if (saquePossivel) {
                                    Operacao operacaoSaque = new Operacao('S', valorSaque); // Instanciação do recibo de
                                                                                            // saque
                                    contaAberta.movimenta(operacaoSaque); // Utilizando o método movimenta para passar
                                                                          // os dados da operação
                                    int[] cedulas = { 100, 50, 20, 10, 5, 2 };

                                    for (int i = 0; i < cedulas.length; i++) {
                                        System.out.println(
                                                "Total de notas de R$" + cedulas[i] + ": " + quantidade[i]);
                                    }
                                    System.out
                                            .println("Saque realizado! Novo saldo: R$ " + contaAberta.getSaldoAtual());
                                } else {
                                    System.out.println("Não é possível realizar o saque com as notas disponíveis");
                                }
                            } else {
                                System.out.println("Saldo insuficiente para o saque.");
                            }
                        } else {
                            System.out.println("Valor inválido");
                        }
                    } else {
                        System.out.println("ERRO! Saque indisponível para Conta de Investimento.");
                    }
                } else {
                    System.out.println("ERRO! Abra uma conta primeiro antes de tentar sacar!");
                }
            }

            else if (opcao == 4) {
                if (contaAberta != null) {
                    if (contaAberta instanceof ContaPoupanca || contaAberta instanceof ContaInvestimento) { // Verifica
                                                                                                            // se a
                                                                                                            // conta
                                                                                                            // aberta
                                                                                                            // permite
                                                                                                            // juros
                        double taxa = Teclado.leDouble("Digite a taxa de juros percentual:");
                        if (taxa <= 0) { // Verifica se a taxa de juros é maior que zero
                            System.out.println("ERRO! A taxa de juros deve ser maior que zero");
                        } else {
                            Operacao operacaoJuros = new Operacao('J', taxa); // Instanciação do objeto OperaçãoJuros,
                                                                              // do tipo 'J'
                            contaAberta.movimenta(operacaoJuros);
                            System.out.println("Juros aplicados! Novo saldo: R$ " + contaAberta.getSaldoAtual());
                        }
                    } else {
                        System.out.println(
                                "ERRO! Para fazer esse tipo de movimentação, você deve ter uma conta poupança ou de investimentos!");
                    }
                } else {
                    System.out.println("ERRO! Abra uma conta primeiro antes de tentar aplicar juros!");
                }
            }

            else if (opcao == 5) {
                if (contaAberta != null) {
                    System.out.println("\n========== EXTRATO BANCÁRIO ==========");

                    System.out.println("--- Dados do Cliente ---");
                    System.out.println("Nome: " + contaAberta.getCliente().getNome());
                    System.out.println("CPF: " + contaAberta.getCliente().getCpf());
                    System.out.println("Data de Nascimento: " + contaAberta.getCliente().getNascimento().toString());

                    System.out.println("\n--- Dados Específicos da Conta ---");
                    if (contaAberta instanceof ContaCorrente) {
                        System.out.println("Tipo de Conta: Conta Corrente");
                        System.out.println("Limite de Crédito: R$ " + ((ContaCorrente) contaAberta).getLimiteCredito());
                    } else if (contaAberta instanceof ContaPoupanca) {
                        System.out.println("Tipo de Conta: Conta Poupança");
                        System.out.println("Dia de Aniversário: " + ((ContaPoupanca) contaAberta).getDiaAniversario());
                    } else {
                        System.out.println("Tipo de Conta: Conta de Investimento");
                        System.out.println("Vencimento do Investimento: "
                                + ((ContaInvestimento) contaAberta).getVencimento().toString());
                    }

                    System.out.println("\n--- Resumo de Saldos ---");
                    System.out.println("Saldo Original (Abertura): R$ " + contaAberta.getSaldoInicial());
                    System.out.println("Saldo Atual: R$ " + contaAberta.getSaldoAtual());
                    System.out.println("Saldo Mínimo Histórico: R$ " + contaAberta.getSaldoMinimo());
                    System.out.println("Saldo Máximo Histórico: R$ " + contaAberta.getSaldoMaximo());

                    System.out.println("\n--- Histórico de Movimentações ---");
                    System.out.println("Depósitos: " + contaAberta.getDepositos().getQuantidade()
                            + " operação(ões) | Total: R$ " + contaAberta.getDepositos().getValorTotal());
                    System.out.println("Saques: " + contaAberta.getSaques().getQuantidade()
                            + " operação(ões) | Total: R$ " + contaAberta.getSaques().getValorTotal());
                    System.out.println("Juros Aplicados: " + contaAberta.getJuros().getQuantidade()
                            + " operação(ões) | Total: R$ " + contaAberta.getJuros().getValorTotal());

                    System.out.println("======================================");
                } else {
                    System.out.println("ERRO! Abra uma conta primeiro antes de pedir o extrato!");
                }
            }

            else if (opcao == 6) {
                System.out.println("\n--- Integrantes ---");
                System.out.println("Aryel Andrada Bergmann");
                System.out.println("Julia Herold de Longhi");
                System.out.println("Natan Victor da Rosa de Oliveira");
                System.out.println("Aryssa Thainá Orita Sirahata");
                System.out.println("Melissa Raupp");
            }

            else if (opcao == 7) {
                System.out.println("\n--- Finalizando Sistema ---");
            }

            else {
                System.out.println("Opção inválida, digite um número de 1 a 7!");
            }
        }
    }
}
