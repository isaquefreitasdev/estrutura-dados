import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();


        // Adicionando clientes à lista
        clientes.add(new Cliente("João", "123.456.789-00"));
        clientes.add(new Cliente("Maria", "987.654.321-00"));
        clientes.add(new Cliente("José", "111.222.333-44"));
        int nM = clientes.size() - 1;




        int inicio = 0;
        int meio;
        int fim = nM;
        boolean finded = false;
        bubbleSort(clientes);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF buscado no formato padrão nacional (XXX.XXX.XXX-XX):");
        String valorBuscado = scanner.nextLine();

        for(int i = 0;i < clientes.size();i++){
            meio = (int)((inicio + fim)/2);
            String cpfMeio = clientes.get(meio).getCpf();
            if(cpfMeio.equals(valorBuscado)){
                finded = true;
                System.out.println(clientes.get(meio).getNome() + " " + clientes.get(meio).getCpf());
                break;

            }else if(cpfMeio.compareTo(valorBuscado) < 0){
                inicio = meio + 1;
            }
            else{
                fim = meio -1;
            }
        }
        if(!finded){
            System.out.println("Não encontrado");


        }


    }

    public static void bubbleSort(List<Cliente> clientes) {
        int n = clientes.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Cliente clienteAtual = clientes.get(j);
                Cliente clienteSeguinte = clientes.get(j + 1);

                // Comparando os CPFs dos clientes e trocando se necessário
                if (clienteAtual.getCpf().compareTo(clienteSeguinte.getCpf()) > 0) {
                    // Trocando os clientes de posição
                    clientes.set(j, clienteSeguinte);
                    clientes.set(j + 1, clienteAtual);
                }
            }
        }
    }

}
