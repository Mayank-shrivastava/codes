import java.io.*;
import java.util.Map;

public class A {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = Map.of(
                "abc", 1,
                "12", 2);

        for (var kv : map.entrySet()) {
            System.out.println(kv.getValue());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        pw.print("Hello world");
        pw.print(val);
        pw.flush();
        pw.close();
    }
}
