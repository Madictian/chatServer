import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient2 {
    private Scanner in;
    private PrintWriter out;
    private String myUsername;


    public void chat(){

        try {
            Socket socket = new Socket("localhost", 59002);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            new Thread(() -> {
                while(true){
                    if (in.hasNext()){
                        System.out.println(in.nextLine());
                    }
                }
            }).start();
            while(true) {
                if (myUsername == null) {
                    //if user has no username, one is requested and sent to the server.
                    System.out.println("Please enter your Name: \n");
                    myUsername = scanner.nextLine();
                    out.println(myUsername);
                }else{
                    out.println(scanner.nextLine());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatClient2 chatClient = new ChatClient2();
        chatClient.chat();
    }
}
