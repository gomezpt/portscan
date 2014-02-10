import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class PortScan{
    
    public static void main(String[] args)
    {
        String ipScan = null;
        int startPort = 0;
        int endPort = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Introduza o numero de IPs a pesquisar:");
        int numberIp = in.nextInt();
        String[] arrayOfIp = new String[numberIp];
        System.out.println("Introduza os IPs a pesquisar");
        for (int j = 0; j < numberIp; j++) {
            arrayOfIp[j] = in.next();
            in.nextLine();
        }
        System.out.println("Introduza a range de portas:");
        startPort = in.nextInt();
        endPort = in.nextInt();
        for (int j = 0; j < numberIp; j++) {
            ipScan = arrayOfIp[j];
            System.out.println("A iniciar pesquisa em " + ipScan + "...");
            for (int port = startPort; port <= endPort; port++) {
                System.out.print(port + "\r");
                try {
                    Socket s = new Socket();
                    int timeout = 100;
                    s.connect(new InetSocketAddress(ipScan, port), timeout);
                    System.out.println("Porta encontrada: " + port);
                    s.close();
                } catch (Exception localException) {
                }
            }
        }
        System.out.println("Pesquisa concluida.");
    }
}
