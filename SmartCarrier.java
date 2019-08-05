import java.io.BufferedReader;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.ListIterator;

public class SmartCarrier {
    private TreeMap<String, ArrayList<Item>> map;

    public SmartCarrier() {
        this.map = new TreeMap<String, ArrayList<Item>>();
    }

    public SmartCarrier(TreeMap<String, ArrayList<Item>> map) {
        this.map = map;
    }

    public void init() {
        Path path = Paths.get("messages.txt");
        Path fullPath = path.toAbsolutePath();
        InputStream input = null;

        String[] array = new String[8];
        String delimiter = ",";
        String messageType;
        String key;

        try {
            input = Files.newInputStream(fullPath);
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(input));
            String s = null;
            s = reader.readLine();
            
            while (s != null) {
                s.trim();

                array = s.split(delimiter);
                messageType = array[0];
                key = array[2];

                if (messageType.compareTo("T") == 0) {
                    Text text = new Text(array[array.length-2]);
                    Item item = new Message<Text>(
                        Integer.parseInt(array[1]),
                        array[2],
                        array[3],
                        Double.parseDouble(array[array.length-1]),
                        text);
                    insertItems(key, item);
                } else if (messageType.compareTo("M") == 0) {
                    Media media = new Media(Double.parseDouble(array[4]),array[5]);
                    Item item = new Message<Media>(
                        Integer.parseInt(array[1]),
                        array[2],
                        array[3],
                        Double.parseDouble(array[array.length-1]),
                        media);
                    insertItems(key, item);
                } else if (messageType.compareTo("V") == 0) {
                    Voice voice = new Voice(Integer.parseInt(array[4]), array[5]);
                    Item item = new Message<Voice>(
                        Integer.parseInt(array[1]),
                        array[2],
                        array[3],
                        Double.parseDouble(array[array.length-1]),
                        voice);
                    insertItems(key, item);
                } else {
                    System.out.println("Didn't read any message");
                }

                s = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void insertItems(String key, Item item) {
        if (map.containsKey(key)) {
            map.get(key).add(item);
        } else {
            ArrayList<Item> messages = new ArrayList<Item>();
            messages.add(item);

            map.put(key, messages);
        }
    }

    public void run() {
        Scanner keyboard = new Scanner(System.in);
        int choice = 4;

        do {
            System.out.println("\tFOOTHILL WIRELESS at Santa Clara");
            System.out.println("MESSAGE UTILIZATION AND ACCOUNT ADMIN");
            System.out.println("1. List all accounts");
            System.out.println("2. Erase the first media message");
            System.out.println("3. Disconnect account");
            System.out.println("4. Quit");
            System.out.print("\nEnter a choice: ");

            choice = keyboard.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\t\tLIST OF ALL ACCOUNTS");
                    listAllAccounts();
                    break;
                case 2:
                    //
                    break;
                case 3:
                    //
                    break;
                case 4:
                    //
                    break;
                default:
                    System.out.println("That is not an option");
                    break;
            }
        } while (choice != 4);

        keyboard.close();
    }

    public void listAllAccounts() {
        Set<Entry<String, ArrayList<Item>>> entries = map.entrySet();
        ListIterator<Item> itr = null;
        double charge = 0.0;
        Item item = null;

        for (Entry<String, ArrayList<Item>> ent : entries) {
            System.out.println("Account: " + ent.getKey());
            itr = ent.getValue().listIterator();

            while (itr.hasNext()) {
                item = itr.next();
                System.out.println(item);

                charge += item.getCharge();
            }
            System.out.printf("Total charge %.2f\n", charge);
            System.out.println("------------------------------------");
            charge = 0.0;
        }
    }

    public static void main(String[] args) {
        SmartCarrier tmobile = new SmartCarrier();
        tmobile.init();
        tmobile.run();
    }
}