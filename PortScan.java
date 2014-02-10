/*    */ import java.io.PrintStream;
/*    */ import java.net.InetSocketAddress;
/*    */ import java.net.Socket;
/*    */ import java.util.Scanner;
/*    */ 
/*    */ public class PortScan
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/*  8 */     String ipScan = null;
/*  9 */     int startPort = 0;
/* 10 */     int endPort = 0;
/* 11 */     Scanner in = new Scanner(System.in);
/* 12 */     System.out.println("Introduza o numero de IPs a pesquisar:");
/* 13 */     int numberIp = in.nextInt();
/* 14 */     String[] arrayOfIp = new String[numberIp];
/* 15 */     System.out.println("Introduza os IPs a pesquisar");
/* 16 */     for (int j = 0; j < numberIp; j++) {
/* 17 */       arrayOfIp[j] = in.next();
/* 18 */       in.nextLine();
/*    */     }
/* 20 */     System.out.println("Introduza a range de portas:");
/* 21 */     startPort = in.nextInt();
/* 22 */     endPort = in.nextInt();
/* 23 */     for (int j = 0; j < numberIp; j++) {
/* 24 */       ipScan = arrayOfIp[j];
/* 25 */       System.out.println("A iniciar pesquisa em " + ipScan + "...");
/* 26 */       for (int port = startPort; port <= endPort; port++) {
/* 27 */         System.out.print(port + "\r");
/*    */         try {
/* 29 */           Socket s = new Socket();
/* 30 */           int timeout = 100;
/* 31 */           s.connect(new InetSocketAddress(ipScan, port), timeout);
/* 32 */           System.out.println("Porta encontrada: " + port);
/* 33 */           s.close();
/*    */         } catch (Exception localException) {
/*    */         }
/*    */       }
/*    */     }
/* 38 */     System.out.println("Pesquisa concluida.");
/*    */   }
/*    */ }

/* Location:           /Users/fclgomes/Downloads/scanv3/portScan.jar
 * Qualified Name:     PortScan
 * JD-Core Version:    0.6.2
 */